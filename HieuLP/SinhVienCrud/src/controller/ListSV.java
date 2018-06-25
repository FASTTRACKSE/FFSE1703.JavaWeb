package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.SinhVien;

/**
 * Servlet implementation class ListSV
 */
public class ListSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = "";
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
		case "/phanTrang":
			phanTrang(request, response);
			break;
		case "/update":
			updateBook(request, response);
			break;
		default:
			listSinhVien(request, response);
			break;
		}
	}

	private void phanTrang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageid = request.getParameter("page");
		int pid = Integer.parseInt(pageid);
		int total = 1;
		if (pid == 1) {
		} else {
			pid = pid - 1;
			pid = (pid * total) + 1;
		}
		List<SinhVien> SV = DAO.getRecords(pid, total);
		request.setAttribute("SinhVien", SV);
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Form.jsp");
		dispatcher1.forward(request, response);
		
	}

	private void listSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			List<SinhVien> SV = DAO.getAllUsers();
			request.setAttribute("SinhVien", SV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Form.jsp");
			dispatcher.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		try {
        	request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
        	String maSinhVien = request.getParameter("maSV");
    		String ten = request.getParameter("name");
    		String gioiTinh = request.getParameter("sex");
    		String tuoi = request.getParameter("age");
    		String lop = request.getParameter("cls");
    		String diaChi = request.getParameter("dress");
			SinhVien SV = new SinhVien(maSinhVien, ten, gioiTinh, tuoi, lop, diaChi);
			DAO.updateBook(SV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Update.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SinhVien SV1;
			String maSV = request.getParameter("maSV");
			SV1 = DAO.getBook(maSV);
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
			DAO.deleteBook(maSinhVien);
			response.sendRedirect("ListSV");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			RequestDispatcher dispatcherNew1 = request.getRequestDispatcher("/Add.jsp");
			dispatcherNew1.forward(request, response);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maSinhVien = request.getParameter("maSV");
			String ten = request.getParameter("name");
			String gioiTinh = request.getParameter("sex");
			String tuoi = request.getParameter("age");
			String lop = request.getParameter("cls");
			String diaChi = request.getParameter("dress");
			SinhVien SV = new SinhVien(maSinhVien, ten, gioiTinh, tuoi, lop, diaChi);
			DAO.insertBook(SV);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcherNew1 = request.getRequestDispatcher("/Add.jsp");
		dispatcherNew1.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
