/**
 * DBUtil.java
 *
 * データベースのアクセスに特化したユーティリティクラス。
 * 意図的にユーザ側に DB 関連のオブジェクトを操作させない様に隠蔽している。
 *
 * トランザクション管理には対応していない。
 *
 * 【使い方】
 * try {
 *   DBUtil.makeConnection();
 *   DBUtil.makeStatement();
 *   ...
 *   ResultSet resultSet = DBUtil.execute("select ...");
 *   if (resultSet != null) {
 *     ...
 *   }
 * } catch (Exception e) { ... }
 * } finally {
 *   DBUtil.closeConnection();
 * }
 *
 * @author A-force Inc.
 */
package jp.co.aforce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jp.co.aforce.bean.ProductBean;

public class ProductDBUtil {
	public class java {

	}

	private static Connection conn = null;	// コネクション
	private static Statement stmt = null;	// ステートメント
	private static ResultSet rs = null;		// リザルトセット

	// データベース(MySQL)にアクセスする為の基本情報。XAMPPを使った時のデフォルトのまま。
	private static String sqlDriver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/";
	private static String database = "shopping?useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String password = "";

	// インスタンス化させない（インスタンス化する必要がないため）。
	private ProductDBUtil() {}

	/**
	 * DBへのコネクションを張る。
	 * @throws Exception
	 */
	public static void makeConnection() throws Exception {
		// 既に取得してある場合はスキップする
		if (conn == null) {
			// JDBC Driver のインスタンス化
			Class.forName(sqlDriver).newInstance();
			// コネクションの取得
			conn = DriverManager.getConnection(url+database+"&user="+user+"&password="+password);
		}
	}

	/**
	 * Statement のオブジェクトをインスタンス化する。
	 * @return Statement or null
	 * @throws Exception
	 */
	public static void makeStatement() throws Exception {
		// 念のためこの処理を挿入しておく
		// もし何らかの理由でコネクションがNULLになっていたとしても処理を継続出来るから
		if (conn == null) {
			makeConnection();
		}
		stmt = conn.createStatement();
	}

	public static ResultSet preparedStatement(String keyword, int minPrice, int maxPrice, String maker, String category1, String category2, String color) throws Exception {
		PreparedStatement st = conn.prepareStatement("select * from product where name like ? and price > ? and price < ? and maker like ? and category1 like ? and category2 like ? and color like ?");
		st.setString(1, "%" + keyword + "%");
		st.setInt(2, minPrice);
		st.setInt(3, maxPrice);
		st.setString(4, "%" + maker + "%");
		st.setString(5, "%" + category1 + "%");
		st.setString(6, "%" + category2 + "%");
		st.setString(7, "%" + color + "%");
		ResultSet rs = st.executeQuery();
		return rs;
	}

	public static int insertProduct(ProductBean product) throws Exception {
		PreparedStatement st = conn.prepareStatement("insert into product values(null, ?, ?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line = st.executeUpdate();

		st.close();
		conn.close();
		return line;
	}

	public static ResultSet executeQuery(int id) throws Exception {
		PreparedStatement st = conn.prepareStatement("select * from product where id = ?");
		st.setInt(1, id);
		ResultSet rs = st.executeQuery();
		return rs;
	}

	public static ResultSet infoSearch(String name) throws Exception {
		PreparedStatement st = conn.prepareStatement("select * from info where name = ?");
		st.setString(1, name);
		ResultSet rs = st.executeQuery();
		return rs;
	}

	/**
	 * SQLを起動する。
	 * @param sql SQL Query
	 * @return ResultSet
	 * @throws Exception
	 */
	public static ResultSet execute(String sql) throws Exception {
		rs = null;
		if(stmt.execute(sql)) {
			rs = stmt.getResultSet();
			if (!rs.next())
				return null;
		}
		return rs;
	}

	public static ResultSet selectJoin(String sql) throws Exception {
		rs = null;
		if (stmt.execute(sql)) {
			rs = stmt.getResultSet();
//			if (!rs.next())
//				return null;
		}
		return rs;
	}

	/**
	 * コネクションをクローズする。
	 * @throws Exception
	 */
	public static void closeConnection() {
		// クローズする順番を間違えない様にする事！
		try {
			if (rs != null) {	// リザルトセットのクローズ
				rs.close();
			}
			if (stmt != null) {	// ステートメントのクローズ
				stmt.close();
			}
			if (conn != null) {
				// conn = null の前にこの処理が無いと NullPointerException が
				// 発生してクローズ出来なくなるので、記述する順番に注意する事！
				conn.close();

				// この処理を忘れると makeConnection() が呼ばれても
				// コネクションが取得出来なくなるので注意
				conn = null;
			}

		// 通常はこのエクセプションの発生は考えにくい
		// 仮に発生する状況が起きた時は、恐らくシステム・エラーが発生しているので
		// 復旧する事は難しいと考えられるが、例外処理を記述しておくのが望ましい
		} catch (SQLException e) {
			// ログファイルに出力するのが一般的
			e.printStackTrace();
		}
	}
}
