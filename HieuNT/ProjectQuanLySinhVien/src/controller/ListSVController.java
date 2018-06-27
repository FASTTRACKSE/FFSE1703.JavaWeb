package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.DAO;
import model.SinhVien;

public class ListSVController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final SinhVien SV = null;
	DAO DAO = new DAO();

	public ListSVController() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = "";
		if (request.getPathInfo() != null) {
			action = request.getPathInfo();
		}
		try {
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
//			default:
//				listSinhVien(request, response);
//				break;
//			}
			default:
				insertBook(request, response);
				break;
			}

			} catch (SQLException e) {
				throw new ServletException(e);
			}

	}

	private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String pageid = request.getParameter("page");
//		int pid = 0;
//		int total = 1;
//		if (request.getParameter("page") != null) {
//			pid = (Integer.parseInt(pageid) - 1) * total;
//		}
//		int soTrang = 0;
//		if (DAO.soTrang() % total == 0) {
//			soTrang = DAO.soTrang() / total;
//		} else {
//			soTrang = DAO.soTrang() / total + 1;
//		}
//		List<SinhVien> SV = model.DAO.getRecords(pid, total);
//		request.setAttribute("SoTrang", soTrang);
//		request.setAttribute("SinhVien", SV);
//		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/ListSV.jsp");
//		dispatcher1.forward(request, response);

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/New.jsp");
			dispatcher1.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		
	    
			RequestDispatcher dispatcherNew1 = request.getRequestDispatcher("/New.jsp");
			dispatcherNew1.forward(request, response);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maSinhVien = request.getParameter("maSV");
			String ten = request.getParameter("name");
			String gioiTinh = request.getParameter("sex");
			String tuoi = request.getParameter("age");
			String lop = request.getParameter("cls");
			String diaChi = request.getParameter("dress");
			String photo = request.getParameter("photo");

			SinhVien SV = new SinhVien(maSinhVien, ten, gioiTinh, tuoi, lop, diaChi,photo);
			model.DAO.insertBook(SV);

		
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		try {
//
//			String maSinhVien = request.getParameter("maSV");
//			model.DAO.deleteBook(maSinhVien);
//			response.sendRedirect("ListSV");
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

//		try {
//			SinhVien SV1;
//			String maSV = request.getParameter("maSV");
//			SV1 = model.DAO.getBook(maSV);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Edit.jsp");
//			request.setAttribute("SV", SV1);
//			dispatcher.forward(request, response);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

//		try {
//			request.setCharacterEncoding("utf-8");
//			response.setCharacterEncoding("utf-8");
//			String maSinhVien = request.getParameter("maSV");
//			String ten = request.getParameter("name");
//			String gioiTinh = request.getParameter("sex");
//			String tuoi = request.getParameter("age");
//			String lop = request.getParameter("cls");
//			String diaChi = request.getParameter("dress");
//			String photo = request.getParameter("photo");
//
//			SinhVien SV = new SinhVien(maSinhVien, ten, gioiTinh, tuoi, lop, diaChi,photo);
//			model.DAO.updateBook(SV);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Edit.jsp");
//			dispatcher.forward(request, response);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
