package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans1.Admin;
import daooo.Admindao;

@WebServlet("/Forgot1passwordservlet")
public class Forgot1passwordservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Forgot1passwordservlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			// 1.get the beans from the jsp pages
			String username = request.getParameter("username");
			String resetpassword = request.getParameter("resetpassword");

			// 2.set these beans using setter methods of bean clas Admin
			Admin a = new Admin();
			a.setUsername(username);
			a.setPassword(resetpassword);

			// 3.call the business method/login from dao class Admindao
			int result = Admindao.updatepassword(username, resetpassword);
			// 4.result decides the next page

			if (result > 0) {
				response.sendRedirect("login1.jsp");
			} else {
				response.sendRedirect("forgot1password.jsp");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
