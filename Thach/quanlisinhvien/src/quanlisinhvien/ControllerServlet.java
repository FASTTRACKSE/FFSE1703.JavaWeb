package quanlisinhvien;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SinhVienDao SinhVienDao;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 String action = request.getServletPath();
    	 
         try {
             switch (action) {
             case "new":
                 showNewForm(request, response);
                 break;
             case "/insert":
//                 insertSinhVien(request, response);
                 break;
             case "/delete":
//                 deleteSinhVien(request, response);
                 break;
             case "/edit":
//                 showEditForm(request, response);
                 break;
             case "/update":
//                 updateSinhVien(request, response);
                 break;
             default:
                 listSinhVien(request, response);
                 break;
             }
         } catch (SQLException ex) {
             throw new ServletException(ex);
         }
     }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request, response);
    }
       
    private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	SinhVienDao = new SinhVienDao();
        List<SinhVien> listSinhVien = SinhVienDao.listAllSinhVien();
        request.setAttribute("listSinhVien", listSinhVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienList.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienForm.jsp");
        dispatcher.forward(request, response);
    }
 
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        SinhVien existingSinhVien = SinhVienDao.getSinhVien(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("SinhVienForm.jsp");
//        request.setAttribute("book", existingSinhVien);
//        dispatcher.forward(request, response);
// 
//    }
 
//    private void insertBook(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//    	String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        String classe = request.getParameter("classe");
// 
//        SinhVien newSinhVien = new SinhVien(name, age, classe);
//        SinhVienDAO.insertSinhVien(newSinhVien);
//        response.sendRedirect("list");
//    }
 
//    private void updateBook(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        String classe = request.getParameter("classe");
// 
//        SinhVien sinhvien = new SinhVien(id, name, age, classe);
//        SinhVienDao.updateSinhVien(sinhvien);
//        response.sendRedirect("list");
//    }
 
//    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
// 
//        SinhVien sinhvien = new SinhVien(id);
//        SinhVienDAO.deleteSinhVien(sinhvien);
//        response.sendRedirect("list");
// 
//    }
}


