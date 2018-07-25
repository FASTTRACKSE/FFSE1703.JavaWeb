package quanlysinhvien;

import java.io.IOException;
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
		    deleteSv(request, response);
		    break;
		case "/update":
		    UpdateSv(request, response);
		    break;
		case "/edit":
			editSv(request, response);
			 break;
		case "/upload":
			upload(request, response);
			 break;	 
		default:
		    listSv(request, response);
		    break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void upload(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpLoadFile.jsp");
		dispatcher.forward(request, response);
	}

	private ArrayList<String> phanTrang() {
		int count = LenhDb.countSv();
		ArrayList <String> arrLink = new ArrayList<String>();
		int trang = count/2;
		if(trang%2==0) {
			
		}else {
			trang=trang+1;
		}
		for(int i=0;i<trang;i++) {
			String link ="<a href=danhsachsv?page='"+(i+1)+"'>"+(i+1)+"</a>";
			arrLink.add(link);
		}
		return arrLink;
	}
		
	
	private void listSv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<SinhVien>arrSv = new ArrayList<SinhVien>();
		ArrayList<String>arrLink = new ArrayList<String>();
		arrSv=LenhDb.SinhVien();
		arrLink=phanTrang();
		request.setAttribute("SinhVien", arrSv);
		request.setAttribute("link", arrLink);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachSv.jsp");
		dispatcher.forward(request, response);
	}

	private void UpdateSv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ma= request.getParameter("code");
		ArrayList<SinhVien>arrSv = new ArrayList<SinhVien>();
		arrSv=LenhDb.selectSv(ma);
		request.setAttribute("SinhVien", arrSv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SuaSv.jsp");
		dispatcher.forward(request, response);
	}

	private void editSv(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String hoDem = request.getParameter("hodem");
		String ten = request.getParameter("ten");
		String ma = request.getParameter("ma");
		String ngSinh = request.getParameter("ngsinh");
		String queQuan = request.getParameter("quequan");
		String gioiTinh =request.getParameter("gioitinh");
		double lp1 = Double.parseDouble(request.getParameter("lp1"));
		double lp2 = Double.parseDouble(request.getParameter("lp2"));
		SinhVien sv = new SinhVien(hoDem, ten, ma, ngSinh, queQuan, gioiTinh, lp1, lp2);
		LenhDb.update(sv);
		response.sendRedirect("danhsachSv");
	}
	
	private void insertSv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemSv.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteSv(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String ma= request.getParameter("ma");
		LenhDb.deleteSv(ma);
		response.sendRedirect("danhsachSv");
	}

	
	private  static void addSv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String hoDem = request.getParameter("hodem");
			String ten = request.getParameter("ten");
			String ma = request.getParameter("ma");
			String ngSinh = request.getParameter("ngsinh");
			String queQuan = request.getParameter("quequan");
			String gioiTinh =request.getParameter("gioitinh");
			double lp1 = Double.parseDouble(request.getParameter("lp1"));
			double lp2 = Double.parseDouble(request.getParameter("lp2"));
			SinhVien sv = new SinhVien(hoDem, ten, ma, ngSinh, queQuan, gioiTinh, lp1, lp2);
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
