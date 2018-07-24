package quanlysinhvien;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LenhDb;
import bean.SinhVien;

/**
 * Servlet implementation class QuanLySV
 */
@WebServlet("/QuanLySV/*")
public class QuanLySV extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QuanLySV() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getPathInfo();
        switch (action) {
        
		case "/new":
		    showNewForm(request, response);
		    break;
		case "/insert":
		    insertSv(request, response);
		    break;
		case "/add":
		    addSv(request, response);
		    break;
		case "/delete":
		    deleteBook(request, response);
		    break;
		case "/update":
		    updateBook(request, response);
		    break;
		default:
		    listSv(request, response);
		    break;
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void listSv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<SinhVien>arrSv = new ArrayList<SinhVien>();
		arrSv=LenhDb.SinhVien();
		request.setAttribute("SinhVien", arrSv);
		//System.out.println(arrSv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachSv.jsp");
		dispatcher.forward(request, response);
		
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void Update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		String ten = request.getParameter("tenSv");
		String ma = request.getParameter("maSv");
		String ngSinh = request.getParameter("ngSinh");
		double lp1 = Double.parseDouble(request.getParameter("diemLp1"));
		double lp2 = Double.parseDouble(request.getParameter("diemLp2"));
		SinhVien sv = new SinhVien(ten, ma, ngSinh, lp1, lp2);
		
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertSv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemSv.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addSv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ten = request.getParameter("tenSv");
		String ma = request.getParameter("maSv");
		String ngSinh = request.getParameter("ngSinh");
		double lp1 = Double.parseDouble(request.getParameter("diemLp1"));
		double lp2 = Double.parseDouble(request.getParameter("diemLp2"));
		SinhVien sv = new SinhVien(ten, ma, ngSinh, lp1, lp2);
		LenhDb.themSV(sv);
		response.sendRedirect("themSV");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
