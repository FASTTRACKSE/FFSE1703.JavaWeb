package com.jsf.crd;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.faces.component.UIComponent;
//import javax.faces.component.UIInput;
//import javax.faces.context.FacesContext;

import com.jsf.crud.db.operations.DatabaseOperation;

@ManagedBean
@RequestScoped
public class StudentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	// @NotNull(message="Please enter the model number")
	private String name;
	private String clas;
	private String email;
	private String phone;
	private String address;
	private String age;
	private String gender;
	@SuppressWarnings("rawtypes")
	private ArrayList studentsListFromDB;

	@PostConstruct
	public void init() {
		studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
	}

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

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
//	public void validateModelNo(FacesContext context, UIComponent comp,
//			Object value) {
//
//		System.out.println("inside validate method");
//
//		String name = (String) value;
//
//		if (name.length() < 10) {
//			((UIInput) comp).setValid(false);
//
//			FacesMessage message = new FacesMessage(
//					"Vui Lòng Nhập tên?");
//			context.addMessage(comp.getClientId(context), message);
//
//		}
//
//	}

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