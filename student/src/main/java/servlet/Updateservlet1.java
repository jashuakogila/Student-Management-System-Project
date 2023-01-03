package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans1.Student;
import daooo.Studentdao;


@WebServlet("/Updateservlet1")
public class Updateservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Updateservlet1() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");

			out.println("<body style='text-align:center;'><head></head>");

			out.println("<h1>Student management project</h1>");
	
			out.println("<div><h3>Update Student Details</h3>");
			int id =Integer.parseInt(request.getParameter("id"));
			
			Student s1=Studentdao.viewstudentbyid(id);
			out.println("<form action='Updateservlet2' method='post'>");
			
			out.println("<input type='hidden' name='id'      value='"+s1.getId()+"'>");
			out.println("<input type='text' name='fullname'  value='"+s1.getFullname()+"'>");
			out.println("<input type='text' name='address'   value='"+s1.getAddress()+"'>");
			out.println("<input type='text' name='email'     value='"+s1.getEmail()+"'>");
			out.println("<input type='text' name='phone'     value='"+s1.getPhone()+"'>");
			
			out.println("<input type='submit' value='update student details'>");
			out.println("</div><br><br>");		
			
			
			
			
			out.println("<div>");
			out.println("<table border='1' width='90%'>");
			out.println("<tr><th>ID</th><th>Fullname</th><th>Address</th><th>Email</th><th>Phone</th></tr>");
				
			java.util.List<Student> list =Studentdao.viewallstudents();
			
			for(Student s: list)
			{
		out.println("<tr><th>"+s.getId()+"</th><th>"+s.getFullname()+"</th><th>"+s.getAddress()+"</th><th>"+s.getEmail()+"</th><th>"+s.getPhone()+"</th><th><a href='Updateservlet1?id="+s.getId()+"'>edit</a></th> <th><a href='Deleteservlet?id="+s.getId()+"'>Delete </a></th>  </tr>");	
		
			}
		
			out.println("</table></div><br><br>");
			out.println("</html></body>");
		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
	}

	


