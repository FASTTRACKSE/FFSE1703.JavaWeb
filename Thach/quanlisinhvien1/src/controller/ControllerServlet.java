package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SinhVien.model.SinhVienDao;
import SinhVien.model.SinhVien;
/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private int page, allPage;
	private static final long serialVersionUID = 1L;
    private SinhVienDao SinhVienDAO= new SinhVienDao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
         try {
             switch (action) {
             case "/new":
                 showNewForm(request, response);
                 break;
             case "/insert":
                 insertSv(request, response);
                 break;
             case "/delete":
                 deleteSv(request, response);
                 break;
             case "/edit":
                 showEditForm(request, response);
                 break;
             case "/update":
                 updateSv(request, response);
                 break;
             default:
                 listSinhVien(request, response);
                 break;
             }
         } catch (SQLException ex) {
             throw new ServletException(ex);
         }
     }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		int maxItem = 2;
		if (request.getParameter("page")==null) {
			page = 0;
		} else {
			page = Integer.parseInt(request.getParameter("page"));
			page = (page -1)*maxItem;
		}
        List<SinhVien> listSinhVien = SinhVienDAO.listAllSinhVien(page, maxItem);
        if (SinhVienDAO.countAll()%maxItem > 0) {
        	allPage = SinhVienDAO.countAll()/maxItem+1;
		} else {
			allPage = SinhVienDAO.countAll()/maxItem;
		}
        request.setAttribute("listSinhVien", listSinhVien);
        request.setAttribute("allpage", allPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SinhVien existingSinhVien = SinhVienDAO.getSv(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienForm.jsp");
        request.setAttribute("Sv", existingSinhVien);
        dispatcher.forward(request, response);
 
    }
 
    private void insertSv(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String masv = request.getParameter("masv");
    	String ten = request.getParameter("ten");
        String ngaysinh = request.getParameter("ngaysinh");
        String quequan = request.getParameter("quequan");
        String gioitinh = request.getParameter("gioitinh");
        String lop = request.getParameter("lop");
        float lp1 = Float.parseFloat(request.getParameter("lp1"));
        float lp2 = Float.parseFloat(request.getParameter("lp2"));
 
        SinhVien newSinhVien = new SinhVien(masv, ten, ngaysinh, quequan, gioitinh, lop, lp1, lp2);
        SinhVienDAO.addSv(newSinhVien);
        response.sendRedirect("list");
    }
 
    private void updateSv(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String masv = request.getParameter("masv");
        String ten = request.getParameter("ten");
        String ngaysinh = request.getParameter("ngaysinh");
        String quequan = request.getParameter("quequan");
        String gioitinh = request.getParameter("gioitinh");
        String lop = request.getParameter("lop");
        float lp1 = Float.parseFloat(request.getParameter("lp1"));
        float lp2 = Float.parseFloat(request.getParameter("lp2"));
 
        SinhVien Sv = new SinhVien( masv, ten, ngaysinh, quequan, gioitinh, lop, lp1, lp2);
        SinhVienDAO.updateSv(id, Sv);
        response.sendRedirect("list");
    }
 
    private void deleteSv(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        SinhVien Sv = new SinhVien(id);
        SinhVienDAO.deleteSv(Sv);
        response.sendRedirect("list");
 
    }
}

