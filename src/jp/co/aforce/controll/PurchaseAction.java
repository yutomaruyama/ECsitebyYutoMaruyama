package jp.co.aforce.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.CustomerBean;
import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.model.PurchaseModel;

@SuppressWarnings("unchecked")
public class PurchaseAction extends HttpServlet {
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
			CustomerBean customer = (CustomerBean)session.getAttribute("customer");

			String name = customer.getName();
			String address = customer.getAddress();


			PurchaseModel dao = new PurchaseModel();
			List<ItemBean> cart = (List<ItemBean>)session.getAttribute("cart");
			try {
				if (!dao.insert(cart, name, address)) {
					forward_jsp = "purchase-error-insert.jsp";
				} else {
					session.setAttribute("cartlog", cart);
					session.removeAttribute("cart");
					session.removeAttribute("customer");
					forward_jsp = "purchase-out.jsp";
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
