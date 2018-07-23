package bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Dao.StudentDAO;

@ManagedBean
@RequestScoped
public class StudentBean {
	private String firstName, lastName, birthYear, gender, email, sdt, diaChi, classSv;
	private int id;
	private ArrayList studentsList;

	public StudentBean() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	
	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getClassSv() {
		return classSv;
	}

	public void setClassSv(String classSv) {
		this.classSv = classSv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@PostConstruct
	public void init() {
		studentsList = StudentDAO.getStudent();
	}

	public ArrayList studentsList() {
		studentsList = StudentDAO.getStudent();
		return studentsList;
	}
	public String deleteStudent(int id) throws SQLException {	
			return StudentDAO.deleteStudent(id);	
	}
	

}
