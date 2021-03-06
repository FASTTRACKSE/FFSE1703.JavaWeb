package students;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
	ConnectDB cn = new ConnectDB();
	Connection conn = (Connection) ConnectDB.getConnect(); // <--Kết nối database-->
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertStudent(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			default:
				// request.getRequestDispatcher("aaa.jsp").forward(request, response);
				listBook(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		studentDAO = new StudentDAO();

		double soStMotTrang = 3.0;
		double tongSt = studentDAO.countSinhVien();
		double soTrang = Math.ceil(tongSt / soStMotTrang);
		int end = 3;
		int trang = 1;
		if (request.getParameter("trang") != null) {
			trang = Integer.parseInt(request.getParameter("trang"));
		}
		int start = (trang - 1) * 3;
		
		List<Student> listStudent = studentDAO.listAllStudents(start, end);
		request.setAttribute("listStudent", listStudent);
		request.setAttribute("soTrang", soTrang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("StudentList.jsp");
		dispatcher.forward(request, response);
	}

	//
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingBook = studentDAO.getStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
		request.setAttribute("student", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("Name");
		String clas = request.getParameter("Class");
		String address = request.getParameter("Address");
		int age = Integer.parseInt(request.getParameter("Age"));
		int author = Integer.parseInt(request.getParameter("Author"));
		double diemlp1 = Double.parseDouble(request.getParameter("Diemlp1"));
		double diemlp2 = Double.parseDouble(request.getParameter("Diemlp2"));
		Student newStudent = new Student(name, clas, address, age, author, diemlp1, diemlp2);
		studentDAO.insertStudent(newStudent);
		response.sendRedirect("list");
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("Name");
		String clas = request.getParameter("Class");
		String address = request.getParameter("Address");
		int age = Integer.parseInt(request.getParameter("Age"));
		int author = Integer.parseInt(request.getParameter("Author"));
		double diemlp1 = Double.parseDouble(request.getParameter("Diemlp1"));
		double diemlp2 = Double.parseDouble(request.getParameter("Diemlp2"));
		
		Student student = new Student(id, name, clas, address, age, author, diemlp1, diemlp2);
		studentDAO.updateStudent(student);
		response.sendRedirect("list");
		 
	}

	//
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));

		Student student = new Student(id);
		studentDAO.deleteStudent(student);
		response.sendRedirect("list");

	}
}
