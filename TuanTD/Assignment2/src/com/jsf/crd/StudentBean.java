package com.jsf.crd;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jsf.crd.Paginator;
import com.jsf.crud.db.operations.DatabaseOperation;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;



@ManagedBean
@RequestScoped
public class StudentBean implements Serializable {

	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
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
	
	DatabaseOperation databaseOperation =new DatabaseOperation();
	@PostConstruct
	public void init() {
		double tongSv = databaseOperation.count();
		System.out.println("count:" + tongSv);
		paginator.pagination(tongSv);
		studentsListFromDB = databaseOperation.getStudentsListFromDB(paginator.start(),paginator.end);
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
	
//	// validate trùng mã sinh viên
	public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
		int exist = databaseOperation.checkExist(value.toString());
		if(exist == 1) {
//			System.out.println(sinhVienDao.checkExist(value.toString()) + "là số lượng");
//			System.out.println(value.toString());
			FacesMessage msg = new FacesMessage("Mã sinh viên đã tồn tại. Vui lòng nhập lại");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
//	Phân Trang

		
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

	public String saveStudentDetails(StudentBean newStudentObj) throws SQLException {
		return databaseOperation.saveStudentDetailsInDB(newStudentObj);
	}

	public String editStudentRecord(int studentId) {
		return databaseOperation.editStudentRecordInDB(studentId);
	}

	public String updateStudentDetails(StudentBean updateStudentObj) {
		return databaseOperation.updateStudentDetailsInDB(updateStudentObj);
	}

	public String deleteStudentRecord(int studentId) {
		return databaseOperation.deleteStudentRecordInDB(studentId);
	}
}