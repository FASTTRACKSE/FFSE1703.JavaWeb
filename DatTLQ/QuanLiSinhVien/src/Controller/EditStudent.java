package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDAO;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/edit")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("submit") == null) {
			showEdit(request, response);
		} else {
			doEdit(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StudentDAO studentDAO = new StudentDAO();
		String id =request.getParameter("id");	
		Student sv=studentDAO.getStuByID(id);
		request.setAttribute("sv", sv);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FormStudent.jsp");
		dispatcher.forward(request, response);
	}
	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Student sv = new Student();
		String ID = request.getParameter("id");
		sv.setId(Integer.parseInt(request.getParameter("id")));
		sv.setFirstName(request.getParameter("firstName"));
		sv.settxtName(request.getParameter("txtName"));
		sv.settxtDate(request.getParameter("txtDate"));
		sv.settxtSex(request.getParameter("txtSex"));
		sv.setQueQuan(request.getParameter("queQuan"));
		sv.settxtLop(request.getParameter("txtLop"));
		sv.setLp1(Float.parseFloat( request.getParameter("lp1")));
		sv.setLp2(Float.parseFloat( request.getParameter("lp2")));
		
		StudentDAO studentDAO = new StudentDAO();
		try {
			studentDAO.repCus(sv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/QuanLiSinhVien/student");
	}

}
