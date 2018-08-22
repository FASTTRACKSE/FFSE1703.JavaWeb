package ffse20.jsf.bean;

import java.util.ArrayList;

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
	private String email;  
	private String lop;  
	private String gender;  
	private String address;
	private String date;

	public ArrayList studentsListFromDB;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
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
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@ManagedProperty(value = "#{Database}")
	private DatabaseOperation studentDao;
	
	@ManagedProperty(value = "#{pagination}")
	private StudentPagin pagination;
	
	public DatabaseOperation getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(DatabaseOperation studentDao) {
		this.studentDao = studentDao;
	}

	public void next() {
		pagination.next();
		setStudentList();
	}

	public void prev() {
		pagination.prev();
		setStudentList();
	}

	public void firstPage() {
		pagination.firstPage();
		setStudentList();
	}

	public void lastPage() {
		pagination.lastPage();
		setStudentList();
	}

	public void setStudentList() {
		this.studentsListFromDB = studentDao.getRecords(pagination.getFromIndex(), pagination.getRecords());
	}
	
	public StudentPagin getPagination() {
		return pagination;
	}

	public void setPagination(StudentPagin pagination) {
		this.pagination = pagination;
	}
	
	@PostConstruct
	public void init() {
		
		int countRecords = studentDao.count();
		pagination.setStudentList(countRecords);
		setStudentList();
		
		//studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
	}

	public ArrayList studentsList() {
		return studentsListFromDB;
	}
	
	public String saveStudentDetails(StudentBean newStudentObj) {
		return DatabaseOperation.saveStudentDetailsInDB(newStudentObj);
	}
	
	public String editStudentRecord(int studentId) {
		return DatabaseOperation.editStudentRecordInDB(studentId);
	}
	
	public String updateStudentDetails(StudentBean updateStudentObj) {
		return DatabaseOperation.updateStudentDetailsInDB(updateStudentObj);
	}
	
	public String deleteStudentRecord(int studentId) {
		return DatabaseOperation.deleteStudentRecordInDB(studentId);
	}
}