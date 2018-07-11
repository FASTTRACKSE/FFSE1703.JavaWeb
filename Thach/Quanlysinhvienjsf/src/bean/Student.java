package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
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
 
    /** Creates a new instance of LophocBean */
    public Student() {
    	//    	
    }
 
    public Student(int id, String hodem, String ten, String namsinh, String gioitinh, String email, String sdt, String diachi, String lop) {
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
	public void init()  {
		try {
			arrStudent = studentDao.listAllStudent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Student> allStudent() throws SQLException {
		arrStudent = studentDao.listAllStudent();
		System.out.println(arrStudent);
		return arrStudent;
	}
	public String deleteStudent(int studentId) {
		 StudentDao.deleteStudent(studentId);
		 return "index";
	}	
	public String saveStudent(Student newStudent) throws SQLException {
		return StudentDao.addSt(newStudent);
	}
	public String editStudent(int studentId) throws SQLException {
		return StudentDao.editStudent(studentId);
	}
	public String updateStudent(Student updateStudent) throws SQLException {
		 return StudentDao.updateStudent(updateStudent);
		    }

}
