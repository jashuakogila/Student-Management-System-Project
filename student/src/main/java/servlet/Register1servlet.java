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

@WebServlet("/Register1servlet")
public class Register1servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Register1servlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			//1.get the beans from the jsp pages
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			//2.set these beans using setter methods of bean clas Admin
			Admin a=new Admin();
			a.setUsername(username);
			a.setPassword(password);
			
			
			//3.call the business method/login from dao class Admindao
		int result=	Admindao.registeradmin(a);
		//4.result decides the next page
		
		if(result >0)
		{
			response.sendRedirect("login1.jsp");
		}
		else
		{
			response.sendRedirect("register1.jsp");	
		}
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}

}
