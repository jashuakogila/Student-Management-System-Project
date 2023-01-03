package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logoutservlet")
public class Logoutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Logoutservlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			HttpSession session=request.getSession();
			session.removeAttribute("a");
			response.sendRedirect("index.jsp");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}}
}