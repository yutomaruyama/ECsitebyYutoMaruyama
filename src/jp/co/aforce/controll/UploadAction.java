package jp.co.aforce.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig()
public class UploadAction extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		doPost (request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int id = (Integer)session.getAttribute("id");
		Part part = request.getPart("file");
		String name = this.getFileName(part);
		if (this.isValidFile(name)) {
			part.write("C:\\pleiades-2019-12-java-win-64bit-jre_20191225\\pleiades\\workspace\\shopping\\WebContent\\img\\" + id + ".jpg");
			System.out.println("C:\\pleiades-2019-12-java-win-64bit-jre_20191225\\pleiades\\workspace\\shopping\\WebContent\\img\\" + name);
			response.sendRedirect("insert-out.jsp");
		} else {
			response.getWriter().println("Invalid file is uploaded.");
		}
	}

	private String getFileName (Part part) {
		String result = null;
		for (String disp : part.getHeader("Content-Disposition").split(";")) {
			disp = disp.trim();
			if (disp.startsWith("filename")) {
				result = disp.substring(disp.indexOf("=") + 1).trim();
				result = result.replace("\"", "").replace("\\", "/");
				int pos = result.lastIndexOf("/");
				if (pos >= 0) {
					result = result.substring(pos + 1);
				}
				break;
			}
		}
		return result;
	}

	private boolean isValidFile (String name) {
		if (name != null) {
			String[] perms = {"jpg"};
			String[] names = name.split("\\.");
			for (String perm: perms) {
				if (perm.equals(names[names.length - 1])){
					return true;
				}
			}
		}
		return false;
	}
}
