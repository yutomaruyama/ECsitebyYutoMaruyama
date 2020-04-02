package jp.co.aforce.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.AlertBean;
import jp.co.aforce.bean.CustomerBean;
import jp.co.aforce.bean.ItemBean;

@SuppressWarnings("unchecked")
public class PrePurchaseAction extends HttpServlet {
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

			String name = request.getParameter("name");
			String address = request.getParameter("address");


			if (name.isEmpty() || address.isEmpty()) {
				AlertBean alert = new AlertBean();
				alert.setError("名前と住所を正しく入力してください！");
				session.setAttribute("alert", alert);
				forward_jsp = "purchase-in.jsp";
			} else {

				List<ItemBean> cart = (List<ItemBean>)session.getAttribute("cart");
				CustomerBean customer = new CustomerBean();

				customer.setName(name);
				customer.setAddress(address);

				try {
					if (cart == null) {
						forward_jsp = "purchase-error-insert.jsp";
					} else {
						session.setAttribute("customer", customer);
						forward_jsp = "purchase-check.jsp";

					}
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					forward_jsp = "purchase-error-insert.jsp";
				}
			}
		}


			RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
			rDispatcher.forward(request, response);

	}

}
