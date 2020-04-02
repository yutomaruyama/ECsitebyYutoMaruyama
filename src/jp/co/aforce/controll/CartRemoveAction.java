package jp.co.aforce.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.bean.TotalBean;

@SuppressWarnings("unchecked")
public class CartRemoveAction extends HttpServlet {
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

			int id = Integer.parseInt(request.getParameter("id"));


			List<ItemBean> cart =(List<ItemBean>)session.getAttribute("cart");
			TotalBean total = (TotalBean)session.getAttribute("total");

			for (ItemBean i : cart) {
				int totalPrice = total.getTotalPrice();
				int totalCount = total.getTotalCount();
				if (i.getProduct().getId() == id) {
					totalPrice -= i.getSubtotalPrice();
					totalCount -= i.getCount();
					cart.remove(i);
					total.setTotalCount(totalCount);
					total.setTotalPrice(totalPrice);
					session.setAttribute("total", total);
					break;
				}
			}
			forward_jsp = "cart.jsp";
		}

			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);

	}

}
