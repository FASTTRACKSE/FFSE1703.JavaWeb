package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@RequestScoped
public class StudentBean {
	private int id;
	private String hoDem, ten, namSinh, gioiTinh, email, dienThoai, diaChi, lop;
	private int trang;
	private double soTrang;
	public ArrayList<StudentBean> studentsListFromDB;

	public StudentDAO studentDAO = new StudentDAO();

	public StudentBean(int id, String hoDem, String ten, String namSinh, String gioiTinh, String email,
			String dienThoai, String diaChi, String lop) {
		super();
		this.id = id;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
		this.lop = lop;
	}

	public StudentBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public int getTrang() {
		return trang;
	}

	public void setTrang(int trang) {
		this.trang = trang;
	}

	public double getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(double soTrang) {
		this.soTrang = soTrang;
	}

	@PostConstruct
	public void init() {
		try {
			
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			this.trang = 1;
			if(request.getParameter("trang")!=null) {
				this.trang = Integer.parseInt(request.getParameter("trang"));
			}
			int start = (this.trang - 1) * 4;
			int end = 4;
			
			double countSv = studentDAO.countSv();
			this.soTrang =  Math.ceil(countSv / 4.0);
			
			studentDAO = new StudentDAO();
			studentsListFromDB = studentDAO.getStudentsListFromDB(start,end);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<StudentBean> studentsList() throws SQLException {
		return studentsListFromDB;
	}

	public String deleteStudentRecord(int studentId) {
		return studentDAO.deleteStudentRecordInDB(studentId);
	}

	public String saveStudentDetails(StudentBean newStudentObj) {
		return studentDAO.insertStudentDetailsInDB(hoDem, ten, namSinh, gioiTinh, email, dienThoai, diaChi, lop);
	}

	public String editStudentRecord(int studentId) throws SQLException {
		return studentDAO.editStudentRecordInDB(studentId);
	}

	public String updateStudentDetails(StudentBean updateStudentObj) throws SQLException {
		return studentDAO.updateStudentDetailsInDB(updateStudentObj);
	}

}
