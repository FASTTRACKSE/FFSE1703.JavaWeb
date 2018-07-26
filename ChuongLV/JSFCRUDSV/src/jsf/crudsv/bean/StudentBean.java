package jsf.crudsv.bean;

 

import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.annotation.PostConstruct;


import jsf.crudsv.pagination.*;
 

import jsf.crudsv.connect.*;

 

@ManagedBean 
@RequestScoped

public class StudentBean {

 

    private int id; 

    private String name; 

    private String email; 

    private String date; 

    private String gender;
    
    private String lop;

    private String address;
    
    private String phone;
    
    //private ArrayList<StudentBean> studentList;

 

    public ArrayList studentsListFromDB;
    //public ArrayList<StudentBean> studentsListFromDB;

 

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

 

    public String getLop() {

        return lop;

    }
    
    
    
    public void setLop(String lop) {

        this.lop = lop;

    }

 

    public String getAddress() {

        return address;

    }

 

    public void setAddress(String address) {

        this.address = address;

    }
    
    
    
    public String getPhone() {

        return phone;

    }

 

    public void setPhone(String phone) {

        this.phone = phone;

    }
    
    @ManagedProperty(value = "#{Database}")
	private ConnectDatabase studentDao;
	
	@ManagedProperty(value = "#{pagination}")
	private StudentPagination pagination;
	
	public ConnectDatabase getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(ConnectDatabase studentDao) {
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
	
	public StudentPagination getPagination() {
		return pagination;
	}

	public void setPagination(StudentPagination pagination) {
		this.pagination = pagination;
	}
	
	@PostConstruct
	public void init() {
		
		int countRecords = studentDao.count();
		pagination.setStudentList(countRecords);
		setStudentList();
		
		//studentsListFromDB = ConnectDatabase.getStudentsListFromDB();
	}


	public ArrayList studentsList() {
		return studentsListFromDB;
	}
     

    public String saveStudentDetails(StudentBean newStudentObj) {

        return ConnectDatabase.saveStudentDetailsInDB(newStudentObj);

    }

     

    public String editStudentRecord(int studentId) {

        return ConnectDatabase.editStudentRecordInDB(studentId);

    }

     

    public String updateStudentDetails(StudentBean updateStudentObj) {

        return ConnectDatabase.updateStudentDetailsInDB(updateStudentObj);

    }

     

    public String deleteStudentRecord(int studentId) {

        return ConnectDatabase.deleteStudentRecordInDB(studentId);

    }

}
