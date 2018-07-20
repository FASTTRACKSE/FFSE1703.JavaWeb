package com.jsf.crud;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.jsf.crud.Paginator;
import com.jsf.crud.db.operations.DatabaseOperation;

@ManagedBean @RequestScoped
public class StudentBean {
	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
	private int id;  
	private String name;  
	private String email;  
	private String password;  
	private String gender;
	private String phone;
	private String address;
	private String lop;
	DatabaseOperation databaseOperation =new DatabaseOperation();
	@SuppressWarnings("rawtypes")
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}  
	
	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	

	@PostConstruct
	public void init() {
		double tongSv = databaseOperation.count();
		System.out.println("count:" + tongSv);
		paginator.pagination(tongSv);
		studentsListFromDB = databaseOperation.getStudentsListFromDB(paginator.start(),paginator.end);
	}
	
	public void next() {
		paginator.next();
		studentsListFromDB = databaseOperation.getStudentsListFromDB(paginator.start(),paginator.end);
		System.out.println(paginator.start());
	}
	public Paginator getPaginator() {
		return paginator;
	}



	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}



	public void prev() {
		paginator.prev();
		studentsListFromDB = databaseOperation.getStudentsListFromDB(paginator.start(),paginator.end);
		System.out.println(paginator.start());
		
	}
	
	public void first() {
		paginator.first();
		studentsListFromDB = databaseOperation.getStudentsListFromDB(paginator.start(),paginator.end);
	}
	
	public void last() {
		paginator.last();
		studentsListFromDB = databaseOperation.getStudentsListFromDB(paginator.start(),paginator.end);
	}

	@SuppressWarnings("rawtypes")
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