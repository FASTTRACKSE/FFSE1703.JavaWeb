package com.jsf.crud;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jsf.crud.db.operations.DatabaseOperation;

@ManagedBean
@SessionScoped
public class StudentBean {

	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String address;
	private String classs;
	private String birtday;
	private String phone;

	private int trang = 1;
	private int banGhiTrenTrang = 2;
	private int tongSoTrang = 3;

	public int getTrang() {
		return trang;
	}

	public void setTrang(int trang) {
		this.trang = trang;
	}

	public void trangTruoc() {
		if (this.trang > 1) {
			this.trang -= 1;
		}
	}

	public void trangSau() {
		if (this.trang < this.tongSoTrang)
		this.trang += 1;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClasss() {
		return classs;
	}

	public void setClasss(String classs) {
		this.classs = classs;
	}

	public String getBirtday() {
		return birtday;
	}

	public void setBirtday(String birtday) {
		this.birtday = birtday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList studentsList() {
		return studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
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