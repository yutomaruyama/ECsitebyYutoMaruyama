package jp.co.aforce.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.model.InsertModel;

@SuppressWarnings("unchecked")
public class InsertAction extends HttpServlet {
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
			ProductBean product = (ProductBean)session.getAttribute("check");


			String name = product.getName();
			int price = product.getPrice();
			String maker = product.getMaker();
			String category1 = product.getCategory1();
			String category2 = product.getCategory2();
			String color = product.getColor();
			int stock = product.getStock();
			String info = product.getInfo();


			if (name.isEmpty() || price <= 0 || maker.isEmpty() || stock <= 0) {
				product.setError("入力内容に不備があります");
				session.setAttribute("alert", product);
				forward_jsp = "insert-in.jsp";
			}

			InsertModel dao = new InsertModel();
			try {
				int id = dao.insert(name, price, maker, category1, category2, color, stock, info);
				if (id == 0) {
					forward_jsp = "insert-error.jsp";
				} else {
					forward_jsp = "insert-out.jsp";
					session.setAttribute("id", id);
					session.removeAttribute("check");

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
