package jp.co.aforce.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.LoginBean;
import jp.co.aforce.model.LoginModel;

@SuppressWarnings("serial")
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		RequestDispatcher rDispatcher = request.getRequestDispatcher("login-error.jsp");
		rDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		LoginModel loginModel = new LoginModel();
		String forward_jsp = "index.jsp";

		if (loginModel.loginCheck(username, password)) {
			if (username.equals("admin")) {
				session.setAttribute("user", loginBean);
				forward_jsp = "admin.jsp";
			} else {
				session.setAttribute("user", loginBean);
				session.removeAttribute("Emsg");
	//			request.setAttribute("user", loginBean.getUsername());

				forward_jsp = "main.jsp";
			}
		}else {
			loginBean.setEmsg ("ユーザ名またはパスワードが違います");
			session.setAttribute("Emsg", loginBean);
		}


		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}



}
