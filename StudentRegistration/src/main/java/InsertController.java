

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertController
 */
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s=new Student();
		s.setSname(request.getParameter("sname"));
		s.setSemail(request.getParameter("semail"));
		s.setSphono(Integer.parseInt(request.getParameter("sphono")));
		s.setSpassword(request.getParameter("spassword"));
		
		StudentDAO dao=new StudentDAO();
		PrintWriter pw= response.getWriter();
		
		try {
			int rows=dao.Insert(s);
			
			if(rows>0) {
				response.sendRedirect("Done.html");
			}
			else {
				response.sendRedirect("NotDone.html");
			}
			
			RequestDispatcher rd= request.getRequestDispatcher("Registration.html");
			rd.include(request, response);
			pw.print("Inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		

	}

}
