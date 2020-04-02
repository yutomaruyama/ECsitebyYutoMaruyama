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
public class DeleteSearchAction extends HttpServlet {
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
			int minPrice = 0;
			int maxPrice = 999999999;
			String maker = request.getParameter("maker");
			String category1 = request.getParameter("category1");
			String category2 = request.getParameter("category2");
			String color = request.getParameter("color");
			if (keyword == null) keyword="";
			if (stMinPrice != "") {
				minPrice = Integer.parseInt(stMinPrice);
			}
			if (stMaxPrice != "") {
				maxPrice = Integer.parseInt(stMaxPrice);
			}
			if (maker == null) maker="";
			if (category1 == null) category1="";
			if (category2 == null) category2="";
			if (color == null) color="";

			ProductModel dao = new ProductModel();
			List<ProductBean> list;
			try {
				list = dao.search(keyword, minPrice, maxPrice, maker, category1, category2, color);

				session.setAttribute("list", list);
				forward_jsp = "delete-in.jsp";
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);
	}

}
