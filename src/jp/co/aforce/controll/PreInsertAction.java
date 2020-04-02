package jp.co.aforce.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ProductBean;

@SuppressWarnings("unchecked")
public class PreInsertAction extends HttpServlet {
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

			ProductBean productBean = new ProductBean();

			String name = request.getParameter("name");
			int price = 0;
			int stock = 0;
			try{
				price = Integer.parseInt(request.getParameter("price"));
				stock = Integer.parseInt(request.getParameter("stock"));
			} catch (NumberFormatException e) {
				productBean.setError("入力内容に不備があります！");
				session.setAttribute("alert", productBean);
				forward_jsp = "insert-in.jsp";
			}
			String maker = request.getParameter("maker");
			String category1 = request.getParameter("category1");
			String category2 = request.getParameter("category2");
			String color = request.getParameter("color");
			String info = request.getParameter("info");

			productBean.setName(name);
			productBean.setPrice(price);
			productBean.setMaker(maker);
			productBean.setCategory1(category1);
			productBean.setCategory2(category2);
			productBean.setColor(color);
			productBean.setStock(stock);
			productBean.setInfo(info);


			if (name.isEmpty() || price <= 0 || maker.isEmpty() || stock <= 0) {
				productBean.setError("入力内容に不備があります！");
				session.setAttribute("alert", productBean);
				forward_jsp = "insert-in.jsp";
			}else {
				forward_jsp = "insert-check.jsp";
				session.setAttribute("check", productBean);
			}
		}


			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);

	}

}
