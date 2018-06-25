package ffse20.quanlysinhvien.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ffse20.quanlysinhvien.dao.*;
import ffse20.quanlysinhvien.model.*;;


/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT = "/sinhvien.jsp";
    private static String Edit = "/edit.jsp";
    private static String UserRecord = "/Menu.jsp";
    private SinhVienDao dao;
    public Main() {
        super();
        dao = new SinhVienDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String redirect="";
        String uId = request.getParameter("id");        
        String action = request.getParameter("action");
        if(!((uId)== null) && action.equalsIgnoreCase("insert"))
        {
        	int id = Integer.parseInt(uId); 
        	SinhVienModel user = new SinhVienModel();
        	user.setId(id);
            user.setHoDem(request.getParameter("hoDem"));
            user.setTen(request.getParameter("ten"));
            user.setNgaySinh(request.getParameter("ngaySinh"));
            user.setGioiTinh(request.getParameter("gioiTinh"));
            user.setQueQuan(request.getParameter("queQuan"));
            user.setLop(request.getParameter("lop"));
            
            
        	dao.addUser(user);
        	redirect = UserRecord;
            request.setAttribute("sinhvien", dao.getAllUsers());    
           	System.out.println("Record Added Successfully");
        }
        else if (action.equalsIgnoreCase("delete")){
            String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);
            dao.removeUser(uid);
            redirect = UserRecord;
            request.setAttribute("sinhvien", dao.getAllUsers());
            System.out.println("Record Deleted Successfully");
        }else if (action.equalsIgnoreCase("editform")){        	
        	redirect = Edit;            
        } else if (action.equalsIgnoreCase("edit")){
        	String userId = request.getParameter("userId");
            int uid = Integer.parseInt(userId);            
            SinhVienModel user = new SinhVienModel();
        	user.setId(uid);
            user.setHoDem(request.getParameter("hoDem"));
            user.setTen(request.getParameter("ten"));
            user.setNgaySinh(request.getParameter("ngaySinh"));
            user.setGioiTinh(request.getParameter("gioiTinh"));
            user.setQueQuan(request.getParameter("queQuan"));
            user.setLop(request.getParameter("lop"));
            dao.editUser(user);
            request.setAttribute("sinhvien", user);
            redirect = UserRecord;
            System.out.println("Record updated Successfully");
         } else if (action.equalsIgnoreCase("listUser")){
            redirect = UserRecord;
            request.setAttribute("sinhvien", dao.getAllUsers());
         } else {
            redirect = INSERT;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
