package sinh_vien_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import model.SinhVien_model;
import model.SinhVienDao;

/**
 * Servlet implementation class SinhVienServlet
 */
@WebServlet("/SinhVienServlet/*")
public class SinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDao sinhVienStatement = new SinhVienDao();
	ArrayList<SinhVien_model> arrSinhVienList = new ArrayList<>();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	static String lang = null;
	public SinhVienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
		
		String action = request.getPathInfo();
		if(action != null) {
			try {
				switch (action) {
				case "/delete":
		           delete(request, response);
		            break;
				case "/add":
			           add(request, response);  // show giao diện add
			        break;
				case "/insert":
			           insertSinhVien(request, response); // insert sinh viên vào database
			        break;
				case "/edit":
			           edit(request, response);  // show giao diện edit
			        break;
				case "/update":
			           updateSinhVien(request, response); // update sinh viên trong database
			        break;
				default:
					SinhVienList(request, response);
					break;
				}
				} catch (SQLException ex) {
					 throw new ServletException(ex);   // bắt buộc phải try catch SQLException
				}
		}
		

		//out.println("Xin chào: " + action);
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

	private void SinhVienList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
//		Sinh_Vien_Statement sv = new Sinh_Vien_Statement();
//		PrintWriter pw = response.getWriter();
//		pw.println(sv.check());
		//response.setCharacterEncoding("UTF-8");
		
		int trang = 1; // mặc định trang đầu tiên là trang 1 vì lúc đầu request.getParameter("trang") = null
		double tongSinhVien = sinhVienStatement.countSinhVien();
		double soBanGhiMotTrang = 4.0; // tổng số bản ghi hiển thị trên 1 trang
		double soTrang = tongSinhVien/soBanGhiMotTrang ; // tính tổng số trang dựa vào số bản ghi để gửi sang view
		if(request.getParameter("trang") != null) {
			trang = Integer.parseInt(request.getParameter("trang")); // trang số trang mà người dùng chọn 1,2,....
			
		}
		
		
						// phần prev
		int prev = 0;
        if (trang == 1) {
            prev = 1;//Luon la trang 1
        } else {
            prev = trang - 1;//Neu trang tu 2 tro len thi back tru 1
        }
        
        
        				// phần next
		int next = 0;
		if(trang < soTrang) {
			next = trang + 1;
		} else if(trang >= soTrang) {
			next = trang;
		}
		
		 
		int start = (trang - 1) * 4; // lấy start để limit
		int end = 4; // lấy end để limit
		//System.out.println(start);
		arrSinhVienList = sinhVienStatement.SinhVienList(start, end);
		
		
		lang = request.getParameter("lang"); // lấy request ngôn ngữ
		if(request.getParameter("lang") == null) {
			lang = "Resource_vn_VN";
		}
	
		request.setAttribute("sinhVienList", arrSinhVienList);
		request.setAttribute("soTrang", Math.ceil(soTrang));
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("lang", lang); // chuyển source ngôn ngữ qua list sinh viên
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("lang", lang); // chuyển source ngôn ngữ qua form add
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVienForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) 
			 throws SQLException, ServletException, IOException {

		String maSv = request.getParameter("maSv");
		SinhVien_model sinhVien = sinhVienStatement.getSv(maSv);
		request.setAttribute("sinhVien", sinhVien);
		request.setAttribute("lang", lang); // chuyển source ngôn ngữ qua form edit
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVienForm.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void insertSinhVien(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String maSv = request.getParameter("maSv");
		String hoTen = request.getParameter("hoTen");
		String tuoi = request.getParameter("tuoi");
		String queQuan = request.getParameter("queQuan");
		String gioiTinh = request.getParameter("gioiTinh");
		String maLop = request.getParameter("maLop");
		double diemLp1 = Double.parseDouble(request.getParameter("diemLp1"));
		double diemLp2 = Double.parseDouble(request.getParameter("diemLp2"));
		
		
//		if(maSv.isEmpty()) {
//			String ero = "Bạn chưa nhập mã sinh viên";
//			request.setAttribute("eroMa", ero); // gửi lỗi sang jsp
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVienForm.jsp");
//			dispatcher.forward(request, response);
//		} else if(hoTen.isEmpty()) {
//			String ero = "Bạn chưa nhập họ tên";
//			request.setAttribute("eroHoTen", ero);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVienForm.jsp");
//			dispatcher.forward(request, response);
//		} else if(diaChi.isEmpty()) {
//			String ero = "Bạn chưa nhập địa chỉ";
//			request.setAttribute("eroDiaChi", ero);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVienForm.jsp");
//			dispatcher.forward(request, response);
//		} else if(dienThoai.isEmpty()) {
//			String ero = "Bạn chưa nhập điện thoại";
//			request.setAttribute("eroDienThoai", ero);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVienForm.jsp");
//			dispatcher.forward(request, response);
//		} else if(maLop.isEmpty()) {
//			String ero = "Bạn chưa nhập mã lớp";
//			request.setAttribute("eroMaLop", ero);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVienForm.jsp");
//			dispatcher.forward(request, response);
//		}
//		else { }
		//request.setAttribute("lang", lang);

			
			SinhVien_model sinhVien = new SinhVien_model(maSv, hoTen, tuoi, queQuan, gioiTinh, maLop, diemLp1, diemLp2);
			sinhVienStatement.insert(sinhVien);
			response.sendRedirect("index?lang=" + lang);
		
		
	}
	
	private void updateSinhVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
	

		String maSv = request.getParameter("maSv");
		String hoTen = request.getParameter("hoTen");
		String tuoi = request.getParameter("tuoi");
		String queQuan = request.getParameter("queQuan");
		String gioiTinh = request.getParameter("gioiTinh");
		String maLop = request.getParameter("maLop");
		double diemLp1 = Double.parseDouble(request.getParameter("diemLp1"));
		double diemLp2 = Double.parseDouble(request.getParameter("diemLp2"));
		
		SinhVien_model sinhVien  = new SinhVien_model(maSv, hoTen, tuoi, queQuan, gioiTinh, maLop, diemLp1, diemLp2);
		sinhVienStatement.update(sinhVien);
		response.sendRedirect("index?lang=" + lang); // index để chuyển về lại trang chủ(ko rơi vào case nào ở trên thì chuyển đến sinhvienList)
													// ?lang=... khi về trang index vẫn giữ đc ngôn ngữ 
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			 throws SQLException, IOException {
		String maSv = request.getParameter("maSv");
		sinhVienStatement.delete(maSv);
		response.sendRedirect("index?lang=" + lang);
		
	}
	

}
