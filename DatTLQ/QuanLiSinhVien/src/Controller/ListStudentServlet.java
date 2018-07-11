package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDAO;

/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/student")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append(request.getParameter("id"));
		StudentDAO studentDAO = new StudentDAO();
		int total =5;
		
		String pageid = request.getParameter("page");
		if (pageid == null) {
			pageid = "1";
		}
		int start = Integer.parseInt(pageid);
		if (start != 1) {
			start = start - 1;
			start = start * total + 1;
		}
		
		int sl = studentDAO.countRecords();
		double lastPage= (sl/5.0);
		
		request.setAttribute("lastPage",(int)Math.ceil(lastPage));

		List<Student> listStudent1 = studentDAO.listStudentPage(start, total);
		request.setAttribute("listStudent", listStudent1);
		request.setAttribute("pageid", pageid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListStudent.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
