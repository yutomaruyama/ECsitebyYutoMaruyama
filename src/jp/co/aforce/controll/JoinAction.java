package jp.co.aforce.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.JoinBean;
import jp.co.aforce.model.JoinModel;

@SuppressWarnings("serial")
//@WebServlet("/LoginServlet")
public class JoinAction extends HttpServlet {

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

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("mailaddress");
			String check = request.getParameter("check");

			JoinBean joinBean = new JoinBean();
			joinBean.setUsername(username);
			joinBean.setPassword(password);
			joinBean.setMailaddress(address);
			joinBean.setCheck(check);

			JoinModel joinModel = new JoinModel();

			if (joinModel.joinCheck(username, password, address, check)) {
				session.setAttribute("Info", joinBean);
				forward_jsp = "member-check.jsp";
			} else {
				joinBean.setEmsg("入力内容に不備があります");
				session.setAttribute("Emsg", joinBean);
				forward_jsp = "member-join.jsp";
			}
		}
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}



}
