package ffse20.quanlysinhvien.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ffse20.quanlysinhvien.connect.*;
import ffse20.quanlysinhvien.dao.*;
import ffse20.quanlysinhvien.modle.*;

/**
 * Servlet implementation class sinhvien
 */
@WebServlet("/sinhvien/*")
public class sinhvien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDao Dao = new SinhVienDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sinhvien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = "";
		try {
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
		case "/update":
			updateBook(request, response);
			break;
		default:
			listSinhVien(request, response);
			break;
		}
		}catch(Exception e) {
			//throw new ServletException(e);
		}
	}

	private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String pageid = request.getParameter("page");
			int pid = 0;
			int total = 1;
			if (request.getParameter("page") != null) {
			pid = (Integer.parseInt(pageid) - 1) * total;
			}
			int soTrang = 0;
			if (SinhVienDao.soTrang() % total == 0) {
			soTrang = SinhVienDao.soTrang() / total;
			} else {
			soTrang = SinhVienDao.soTrang() / total + 1;
			}
			List<SinhVienModle> SV = SinhVienDao.getRecords(pid, total);
			request.setAttribute("SoTrang", soTrang);
			request.setAttribute("SinhVien", SV);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/Form.jsp");
			dispatcher1.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maSinhVien = request.getParameter("userid");
			String ten = request.getParameter("name");
			String gioiTinh = request.getParameter("gioitinh");
			String tuoi = request.getParameter("ngaysinh");
			String lop = request.getParameter("lop");
			String diaChi = request.getParameter("quequan");
			SinhVienModle SV = new SinhVienModle(maSinhVien, ten, tuoi, diaChi, gioiTinh, lop);
			SinhVienDao.updateBook(SV);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Update.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SinhVienModle SV1;
			String maSV = request.getParameter("maSV");
			SV1 = SinhVienDao.getBook(maSV);
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
			SinhVienDao.deleteBook(maSinhVien);
			response.sendRedirect("CRUDSinhVien");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			RequestDispatcher dispatcherNew1 = request.getRequestDispatcher("/Add.jsp");
			dispatcherNew1.forward(request, response);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maSinhVien = request.getParameter("userid");
			String ten = request.getParameter("name");
			String gioiTinh = request.getParameter("gioitinh");
			String tuoi = request.getParameter("ngaysinh");
			String lop = request.getParameter("lop");
			String diaChi = request.getParameter("quequan");
			SinhVienModle SV = new SinhVienModle(maSinhVien, ten, tuoi, diaChi, gioiTinh, lop);
			SinhVienDao.insertBook(SV);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcherNew1 = request.getRequestDispatcher("/Add.jsp");
		dispatcherNew1.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
