package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.SinhVien;

public class CRUDSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao Dao = new UserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDSinhVien() {
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
		String action = "";
		try {
		if (request.getPathInfo() != null) {
			action = request.getPathInfo();
		}
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertBook(request, response);
			break;
		case "/delete":
			deleteBook(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateBook(request, response);
			break;
		default:
			listSinhVien(request, response);
			break;
		}
		}catch(Exception e) {
			//throw new ServletException(e);
		}
	}

	private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String pageid = request.getParameter("page");
			int pid = 0;
			int total = 1;
			if (request.getParameter("page") != null) {
			pid = (Integer.parseInt(pageid) - 1) * total;
			}
			int soTrang = (int) Math.ceil((double) UserDao.soTrang() /(double) total);
			
			List<SinhVien> SV = UserDao.getRecords(pid, total);
			request.setAttribute("SoTrang", soTrang);
			request.setAttribute("SinhVien", SV);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Form.jsp");
			dispatcher1.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maSinhVien = request.getParameter("userid");
			String ten = request.getParameter("name");
			String gioiTinh = request.getParameter("gioitinh");
			String tuoi = request.getParameter("ngaysinh");
			String lop = request.getParameter("lop");
			String diaChi = request.getParameter("quequan");
			SinhVien SV = new SinhVien(maSinhVien, ten, tuoi, diaChi, gioiTinh, lop);
			UserDao.updateBook(SV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Update.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SinhVien SV1;
			String maSV = request.getParameter("maSV");
			SV1 = UserDao.getBook(maSV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Update.jsp");
			request.setAttribute("SV", SV1);
			dispatcher.forward(request, response);
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {

			String maSinhVien = request.getParameter("maSV");
			UserDao.deleteBook(maSinhVien);
			response.sendRedirect("CRUDSinhVien");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			RequestDispatcher dispatcherNew1 = request.getRequestDispatcher("/Add.jsp");
			dispatcherNew1.forward(request, response);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maSinhVien = request.getParameter("userid");
			String ten = request.getParameter("name");
			String gioiTinh = request.getParameter("gioitinh");
			String tuoi = request.getParameter("ngaysinh");
			String lop = request.getParameter("lop");
			String diaChi = request.getParameter("quequan");
			SinhVien SV = new SinhVien(maSinhVien, ten, tuoi, diaChi, gioiTinh, lop);
			UserDao.insertBook(SV);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcherNew1 = request.getRequestDispatcher("/Add.jsp");
		dispatcherNew1.forward(request, response);

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
