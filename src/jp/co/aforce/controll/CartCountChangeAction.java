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
import jp.co.aforce.model.ProductModel;

@SuppressWarnings("unchecked")
public class CartCountChangeAction extends HttpServlet {
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
			int count = Integer.parseInt(request.getParameter("count"));


			List<ItemBean> cart =(List<ItemBean>)session.getAttribute("cart");

			ProductModel dao = new ProductModel();
			TotalBean total = new TotalBean();

			try {
				if (!dao.stockOver(id, count)) {
					forward_jsp = "cart.jsp";
				} else {
					int totalCount = 0;
					int totalPrice = 0;
					for (ItemBean i : cart) {
						if (i.getProduct().getId()==id) {
							i.setCount(count);
							i.setSubtotalPrice(i.getProduct().getPricetax() * count);
							forward_jsp = "cart.jsp";
						}
						totalCount += i.getCount();
						totalPrice += i.getSubtotalPrice();
					}
					total.setTotalCount(totalCount);
					total.setTotalPrice(totalPrice);
					session.setAttribute("total", total);
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
