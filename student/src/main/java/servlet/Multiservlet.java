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

@WebServlet("/Multiservlet")
public class Multiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Multiservlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");

			out.println("<body style='text-align:center;'><head></head>");

			out.println("<h1>Student management project</h1>");

			out.println("<form action='Multiservlet' method='get'>");
			out.println("<input type='text' name='stringvalue'>");
			out.println("<input type='submit' value='search'>");

			out.println("</form>");

			out.println("<div><h3>Insert new student details</h3>");
			out.println("<form action='Insertstudentservlet'method='post'>");
			out.println("<input type='text' name='fullname' placeholder='fullname'>");
			out.println("<input type='text' name='address' placeholder='address'>");
			out.println("<input type='text' name='email' placeholder='email'>");
			out.println("<input type='text' name='phone' placeholder='phone'>");

			out.println("<input type='submit' value='insert new student'>");
			out.println("</div><br><br>");

			out.println("<div><h3> LIST OF ALL STUDENTS</h3>");
			out.println("<table border='1' width='90%'>");
			out.println("<tr><th>ID</th><th>Fullname</th><th>Address</th><th>Email</th><th>Phone</th></tr>");

			boolean status = Number_or_String.isnumberornot(request.getParameter("stringvalue"));

			if (status == true) {
				int id = Integer.parseInt(request.getParameter("stringvalue"));

				Student s1 = Studentdao.viewstudentbyid(id);
				out.println("<tr><th>" + s1.getId() + "</th><th>" + s1.getFullname() + "</th><th>" + s1.getAddress()
						+ "</th><th>" + s1.getEmail() + "</th><th>" + s1.getPhone()
						+ "</th><th><a href='Updateservlet1?id=" + s1.getId()
						+ "'>edit</a></th> <th><a href='Deleteservlet?id=" + s1.getId() + "'>Delete </a></th>  </tr>");

				out.println("</table></div><br><br>");
			} else {
				String stringvalue = request.getParameter("stringvalue");

				java.util.List<Student> list = Studentdao.viewmultipleoptions(stringvalue);

				for (Student s : list) {
					out.println("<tr><th>" + s.getId() + "</th><th>" + s.getFullname() + "</th><th>" + s.getAddress()
							+ "</th><th>" + s.getEmail() + "</th><th>" + s.getPhone()
							+ "</th><th><a href='Updateservlet1?id=" + s.getId()
							+ "'>edit</a></th> <th><a href='Deleteservlet?id=" + s.getId()
							+ "'>Delete </a></th>  </tr>");

				}

				out.println("</table></div><br><br>");
			}
			out.println("</html></body>");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
