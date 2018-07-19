package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Student {
	private int id;
	private String hodem;
	private String ten;
	private String namsinh;
	private String gioitinh;
	private String email;
	private String sdt;
	private String diachi;
	private String lop;
	public StudentDao studentDao = new StudentDao();
	public ArrayList<Student> arrStudent;

	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
	
	/** Creates a new instance of LophocBean */
	public Student() {
		//
	}

	public Student(int id, String hodem, String ten, String namsinh, String gioitinh, String email, String sdt,
			String diachi, String lop) {
		super();
		this.id = id;
		this.hodem = hodem;
		this.ten = ten;
		this.namsinh = namsinh;
		this.gioitinh = gioitinh;
		this.email = email;
		this.sdt = sdt;
		this.diachi = diachi;
		this.lop = lop;
	}

	
	
	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public String getHodem() {
		return hodem;
	}

	public void setHodem(String hodem) {
		this.hodem = hodem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	@PostConstruct
	public void init() {
		try {
			double tongSv = studentDao.count();
			paginator.pagination(tongSv);
			arrStudent = studentDao.listAllStudent(paginator.start(), paginator.end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void next() throws SQLException {
		paginator.next();
		arrStudent = studentDao.listAllStudent(paginator.start(), paginator.end);
		System.out.println(paginator.start());
	}
	
	public void prev() throws SQLException {
		paginator.prev();
		arrStudent = studentDao.listAllStudent(paginator.start(), paginator.end);
		System.out.println(paginator.start());
	}
	
	public void first() throws SQLException {
		paginator.first();;
		arrStudent = studentDao.listAllStudent(paginator.start(), paginator.end);
	}
	
	public void last() throws SQLException {
		paginator.last();
		arrStudent = studentDao.listAllStudent(paginator.start(), paginator.end);
	}
	
	public ArrayList<Student> allStudent() throws SQLException {
		arrStudent = studentDao.listAllStudent(paginator.start(), paginator.end);
		return arrStudent;
	}

	public String deleteStudent(int studentId) throws SQLException {
		String st = StudentDao.deleteStudent(studentId);
//		double tongSv = studentDao.count();
//		paginator.pagination(tongSv);
		return st;
	}

	public String xoaStudent(int studentId) throws SQLException {
		 String st= "index";//StudentDao.deleteStudent(studentId);
		 double tongSv = studentDao.count();
		 paginator.pagination(tongSv);
		 return st;
	}

	public String saveStudent(Student newStudent) throws SQLException {
		 String st= StudentDao.addSt(newStudent);
		 double tongSv = studentDao.count();
		 paginator.pagination(tongSv);
		 return st;
	}

	public String editStudent(int studentId) throws SQLException {
		return StudentDao.editStudent(studentId);
	}

	public String updateStudent(Student updateStudent) throws SQLException {
		return StudentDao.updateStudent(updateStudent);
	}

}
