package jp.co.aforce.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.LoginBean;
import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.model.ProductModel;

@SuppressWarnings("serial")
public class ProductAction extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		doPost (request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		String forward_jsp = null;
		if(request.getSession(true).isNew()) {
			forward_jsp = "sessiontimeout.jsp";
		} else {

			HttpSession session = request.getSession();
			LoginBean loginBean = new LoginBean();
			loginBean = (LoginBean) session.getAttribute("user");

			String keyword = request.getParameter("keyword");
			String stMinPrice = request.getParameter("minprice");
			String stMaxPrice = request.getParameter("maxprice");
			int minPrice = -1;
			int maxPrice = 999999999;
			String maker = request.getParameter("maker");
			String category1 = request.getParameter("category1");
			if (!(category1 == null)) {
				switch (category1) {
				case "audio":
					category1 = "オーディオ";
					break;
				case "instrument":
					category1 = "楽器";
					break;
				default:
					break;
				}
			}
			String category2 = request.getParameter("category2");
			if (!(category2 == null)) {
				switch (category2) {
				case "portablespeaker":
					category2 = "ポータブルスピーカー";
					break;
				case "electricalguiter":
					category2 = "エレキギター";
					break;
				case "earphone":
					category2 = "イヤホン";
					break;
				case "portableplayer":
					category2 = "ポータブルプレーヤー";
					break;
				case "electricalpiano":
					category2 = "電子ピアノ";
					break;
				case "headphone":
					category2 = "ヘッドホン";
					break;
				case "DAWsoftwear":
					category2 = "DAWソフトウェア";
					break;
				default:
					break;
				}
			}
			String color = request.getParameter("color");
			if (keyword == null) keyword="";
			if (stMinPrice == null) stMinPrice="";
			if (stMinPrice != "") {
				minPrice = Integer.parseInt(stMinPrice);
			}
			if (stMaxPrice == null) stMaxPrice="";
			if (stMaxPrice != "") {
				maxPrice = Integer.parseInt(stMaxPrice);
			}
			if (maker == null) maker="";
			if (category1 == null) category1="";
			if (category2 == null) category2="";
			if (color == null) color="";

			ProductBean search = new ProductBean();
			search.setName(keyword);
			search.setMinPrice(minPrice);
			search.setMaxPrice(maxPrice);
			search.setMaker(maker);
			search.setCategory1(category1);
			search.setCategory2(category2);
			search.setColor(color);

			ProductModel dao = new ProductModel();
			List<ProductBean> list;
			try {
				list = dao.search(keyword, minPrice, maxPrice, maker, category1, category2, color);

				session.setAttribute("list", list);
				session.setAttribute("search", search);

				if (loginBean.getUsername().equals("admin")) {
					forward_jsp = "select-in.jsp";
				}else {
					forward_jsp = "result.jsp";
				}
				if (request.getSession(true).isNew()) {
					forward_jsp ="sessiontimeout.jsp";
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);
	}

}
