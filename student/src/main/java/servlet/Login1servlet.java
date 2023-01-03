package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans1.Admin;
import daooo.Admindao;

@WebServlet("/Login1servlet")
public class Login1servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login1servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			//1.get the beans from the jsp pages
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			
			HttpSession session=request.getSession();
			
			session.setAttribute("a", username);
			
			
			//2.set these beans using setter methods of bean clas Admin
			/*Admin a=new Admin();
			a.setUsername(username);
			a.setPassword(password);*/
			
			
			//3.call the business method/login from dao class Admindao
		int result=	Admindao.loginadmin(username,password);
		//4.result decides the next page
		
		if(result >0)
		{
			response.sendRedirect("Viewallservlet");
		}
		else
		{
			response.sendRedirect("login1.jsp");	
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	
	}

	

}
