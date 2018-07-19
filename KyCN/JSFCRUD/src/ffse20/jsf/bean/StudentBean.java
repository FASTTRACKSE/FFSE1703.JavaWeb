package ffse20.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ffse20.jsf.connect.*;
import ffse20.jsf.pagination.*;

@ManagedBean @RequestScoped
public class StudentBean {

	private int id;  
	private String name; 
	private String lop;
	private String email;  
	private String date;  
	private String gender;  
	private String address;
	public ArrayList<StudentBean> studentsListFromDB;
	
	
	
	


	public int getId() {
		return id;	
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}  
	
	@ManagedProperty(value = "#{Database}")
	private Connect studentDao;
	
	@ManagedProperty(value = "#{pagination}")
	private StudentPagin pagination;
	@PostConstruct
//	public void init() {
//		int countRecords = studentDao.countRecords();
//		pagination.setStudentList(countRecords);
//		setStudentList();	
//	}

	public ArrayList<StudentBean> studentList() {
		return studentsListFromDB;
	}
	
	
	
	
//	// Pagination
//	public void next() {
//		pagination.next();
//		setStudentList();
//	}
//
//	public void prev() {
//		pagination.prev();
//		setStudentList();
//	}
//
//	public void firstPage() {
//		pagination.firstPage();
//		setStudentList();
//	}
//
//	public void lastPage() {
//		pagination.lastPage();
//		setStudentList();
//	}
//
//	public void setStudentList() {
//		this.studentsListFromDB = studentDao.getRecords(pagination.getFromIndex(), pagination.getRecords());
//	}
	
//	public void init() {
//		studentsListFromDB = Connect.getStudentsListFromDB();
//	}
//
//	public ArrayList studentsList() {
//		return studentsListFromDB;
//	}
//	
	public String saveStudentDetails(StudentBean newStudentObj) {
		return Connect.saveStudentDetailsInDB(newStudentObj);
	}
	
	public String editStudentRecord(int studentId) {
		return Connect.editStudentRecordInDB(studentId);
	}
	
	public String updateStudentDetails(StudentBean updateStudentObj) {
		return Connect.updateStudentDetailsInDB(updateStudentObj);
	}
	
	public String deleteStudentRecord(int studentId) {
		return Connect.deleteStudentRecordInDB(studentId);
	}
	
	public Connect getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(Connect studentDao) {
		this.studentDao = studentDao;
	}

	public StudentPagin getPagination() {
		return pagination;
	}

	public void setPagination(StudentPagin pagination) {
		this.pagination = pagination;
	}
}