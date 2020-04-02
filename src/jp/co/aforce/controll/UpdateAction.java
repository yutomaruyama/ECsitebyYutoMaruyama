package jp.co.aforce.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.model.SelectModel;

@SuppressWarnings("unchecked")
public class UpdateAction extends HttpServlet {
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

			int id = product.getId();
			String name = product.getName();
			int price = product.getPrice();
			String maker = product.getMaker();
			String category1 = product.getCategory1();
			String category2 = product.getCategory2();
			String color = product.getColor();
			int stock = product.getStock();

			if (name.isEmpty() || price <= 0 || maker.isEmpty() || stock <= 0) {
				forward_jsp = "select-info.jsp";
			}

			SelectModel dao = new SelectModel();
			try {
				if (!dao.select(id, name, price, maker, category1, category2, color, stock)) {
					forward_jsp = "select-info.jsp";
				} else {
					forward_jsp = "select-out.jsp";
					session.removeAttribute("list");
					session.removeAttribute("check");
					session.removeAttribute("info");

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
