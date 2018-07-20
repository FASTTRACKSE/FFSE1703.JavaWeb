package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import bean.dao.*;
import bean.pagination.Pagination;
@ManagedBean
@RequestScoped
public class StudentBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String address;
	private List<StudentBean> studentList;

	@ManagedProperty(value = "#{studentDao}")
	private studentDao studentDao;

	@ManagedProperty(value = "#{pagination}")
	private Pagination pagination;

	@PostConstruct
	public void init() {
		int countRecords = studentDao.countRecords();
		pagination.setStudentList(countRecords);
		setStudentList();
	}

	public List<StudentBean> studentList() {
		return studentList;
	}

	// Pagination
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
		this.studentList = studentDao.getRecords(pagination.getFromIndex(), pagination.getRecords());
	}

	// CRUD

	public String index() {
		return "/index.xhtml?faces-redirect=true";
	}

	public String addNew(StudentBean u) {
		return studentDao.addNew(u);
	}

	public String getById(int Id) {
		return studentDao.getById(Id);

	}

	public String Update(StudentBean u) {
		return studentDao.Update(u);
	}

	public String delete(int Id) {
		return studentDao.delete(Id);
	}

	public StudentBean() {
		super();
	}

	public StudentBean(int id, String name, String email, String password, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.address = address;
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

	public studentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(studentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}