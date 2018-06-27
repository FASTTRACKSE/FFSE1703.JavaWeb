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
 * Servlet implementation class AddStudent
 */
@WebServlet("/add")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
			showAdd(request, response);
		} else {
			doAdd(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void showAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FormStudent.jsp");
		dispatcher.forward(request, response);
	}
	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Student sv = new Student();
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
			studentDAO.addSV(sv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/QuanLiSinhVien/student");
	}
}
