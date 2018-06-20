package javaweb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import javaweb.modle.bean.Student;
import javaweb.modle.dao.StudentDAO;


/**
 * Servlet implementation class ControllerStudent
 */
@WebServlet("/ControllerStudent/*")
public class ControllerStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String lang = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerStudent() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				insertStuden(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteStudent(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			editStudent(request, response);
			break;
		case "/update":
			try {
				updateStuden(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				listStudent(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("lang", lang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/NewStudent.jsp");
		dispatcher.forward(request, response);
	}

	protected void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String pageId = request.getParameter("page");
		int start = 0;
		int totalSt = 2;
		if (pageId == null) {
			start = 0;
		} else {
			start = Integer.parseInt(pageId);
			if (start == 1) {
				start = 0;
			} else {
				start = (start-1) * totalSt;
			}
		}
		lang = request.getParameter("lang");
		if (lang == null) {
			lang = "resousces_vn_VN";
		}
		List<Student> listStudent = StudentDAO.selectStudent(start, totalSt);
		int totalStudent = StudentDAO.totalStudent();
		int totalPage = totalStudent / 2;
		request.setAttribute("lang", lang);
		request.setAttribute("total", totalPage);
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListStudent.jsp");
		dispatcher.forward(request, response);
	}

	private void insertStuden(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String classSt = request.getParameter("class");
		String sex = request.getParameter("sex");
		String country = request.getParameter("country");
		double lp1 = Double.parseDouble(request.getParameter("lp1"));
		double lp2 = Double.parseDouble(request.getParameter("lp2"));

		Student newStudent = new Student(code, name, age, classSt, sex, country, lp1, lp2);
		StudentDAO.insertStudent(newStudent);
		response.sendRedirect("list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setAttribute("lang", lang);
		String maSV = request.getParameter("code");
		StudentDAO.deleteStudent(maSV);
		response.sendRedirect("list");
	}
	protected void editStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		Student st = StudentDAO.getStudent(code);
		request.setAttribute("Student", st);
		request.setAttribute("lang", lang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/EditStudent.jsp");
		dispatcher.forward(request, response);
	}
	private void updateStuden(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String classSt = request.getParameter("class");
		String sex = request.getParameter("sex");
		String country = request.getParameter("country");
		double lp1 = Double.parseDouble(request.getParameter("lp1"));
		double lp2 = Double.parseDouble(request.getParameter("lp2"));
		
		request.setAttribute("lang", lang);
		Student student = new Student(code, name, age, classSt, sex, country, lp1, lp2);
		StudentDAO.updateStudent(student);
		response.sendRedirect("list");
	}

}
