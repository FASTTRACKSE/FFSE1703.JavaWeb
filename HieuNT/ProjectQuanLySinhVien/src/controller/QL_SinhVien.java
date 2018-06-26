package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.SinhVien;
@WebServlet("/QL_SinhVien")

public class QL_SinhVien extends HttpServlet {



	private static final long serialVersionUID = 1L;
	private DAO dao;

       
    
    public QL_SinhVien() {
        super();

        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//				SinhVien SV = new SinhVien("SV1","LAM","21","abc","Abc");	
//				List<SinhVien> ar_sv = new ArrayList<SinhVien>();
//				ar_sv.add(SV);
//				RequestDispatcher dis = request.getRequestDispatcher("/Form.jsp");
//				request.setAttribute("list_SV", ar_sv);
//				dis.forward(request, response);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/Form.jsp");
	        dispatcher.forward(request, response);

	}
}
