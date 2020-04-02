package jp.co.aforce.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.bean.ProductBean;
import jp.co.aforce.bean.TotalBean;
import jp.co.aforce.model.ProductModel;

@SuppressWarnings("unchecked")
public class CartAddAction extends HttpServlet {
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
			if (cart == null) {
				cart = new ArrayList<ItemBean>();
				session.setAttribute("cart", cart);
			}

			ProductModel dao = new ProductModel();

			try {
				if (!dao.stockOver(id, count)) {
					ProductBean search = (ProductBean)session.getAttribute("search");
					search.setError("在庫が足りません！");
					session.setAttribute("search", search);
					forward_jsp = "result.jsp";
				} else {
					for (ItemBean i : cart) {
						if (i.getProduct().getId()==id) {
							i.setCount(i.getCount()+count);
							forward_jsp = "cart.jsp";
						}
					}

					List<ProductBean> list = (List<ProductBean>)session.getAttribute("list");
					for (ProductBean p : list) {
						if (p.getId()==id) {
							ItemBean i = new ItemBean();
							i.setProduct(p);
							i.setCount(count);
							i.setSubtotalPrice(p.getPricetax() * count);
							cart.add(i);
						}
					}
					int totalPriceInt = 0;
					int totalCountInt = 0;
					for (ItemBean i : cart) {
						totalCountInt += i.getCount();
						totalPriceInt += i.getProduct().getPricetax() * i.getCount();
					}
					TotalBean total = new TotalBean();
					total.setTotalCount(totalCountInt);
					total.setTotalPrice(totalPriceInt);
					session.setAttribute("total", total);
					forward_jsp = "cart.jsp";
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
