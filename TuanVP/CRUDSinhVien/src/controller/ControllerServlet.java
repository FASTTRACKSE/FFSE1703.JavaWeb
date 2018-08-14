package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SinhVien;
import model.dao.StudentDAO;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		studentDAO = new StudentDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

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
				showFormInsert(request, response);
				break;
			case "/insert":
				insertStudent(request, response);
				break;
			case "/edit":
				showFormEdit(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			default:
				listSinhVien(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		SinhVien sv = new SinhVien(id);
		studentDAO.deleteStudent(sv);
		response.sendRedirect("/list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String hodem = request.getParameter("hodem");
		String ten = request.getParameter("ten");
		String ngaysinh = request.getParameter("ngaysinh");
		String gioitinh = request.getParameter("gioitinh");
		String quequan = request.getParameter("quequan");
		String lop = request.getParameter("lop");
		float diemlp1 = Float.parseFloat(request.getParameter("diemlp1"));
		float diemlp2 = Float.parseFloat(request.getParameter("diemlp2"));

		SinhVien sv = new SinhVien(id, hodem, ten, ngaysinh, gioitinh, quequan, lop, diemlp1, diemlp2);
		studentDAO.updateStudent(sv);
		response.sendRedirect("list");
	}

	private void showFormEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		SinhVien sv = new SinhVien(id);
		SinhVien extsv = studentDAO.getSinhVien(sv);
		request.setAttribute("sv", extsv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Form.jsp");
		dispatcher.forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String hodem = request.getParameter("hodem");
		String ten = request.getParameter("ten");
		String ngaysinh = request.getParameter("ngaysinh");
		String gioitinh = request.getParameter("gioitinh");
		String quequan = request.getParameter("quequan");
		String lop = request.getParameter("lop");
		float diemlp1 = Float.parseFloat(request.getParameter("diemlp1"));
		float diemlp2 = Float.parseFloat(request.getParameter("diemlp2"));
		SinhVien sv = new SinhVien(hodem, ten, ngaysinh, gioitinh, quequan, lop, diemlp1, diemlp2);
		studentDAO.insertStudent(sv);
		response.sendRedirect("list");
	}

	private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int start = 0;
		int perPage = 1;
		int page = 1;
		String lang = request.getParameter("lang");
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			start = (page - 1) * perPage;
		}
		int total = (int) Math.ceil(studentDAO.rowCount() / perPage);
		request.setAttribute("page", page);
		request.setAttribute("totalPage", total);
		request.setAttribute("lang", lang);
		List<SinhVien> listSinhVien = studentDAO.listSinhVien(start, perPage);
		request.setAttribute("listSinhVien", listSinhVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("List.jsp");
		dispatcher.forward(request, response);

	}

	private void showFormInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Form.jsp");
		dispatcher.forward(request, response);
	}

}
