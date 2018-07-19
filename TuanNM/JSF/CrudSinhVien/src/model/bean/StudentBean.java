package model.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.dao.StudentDAO;

@ManagedBean
@SessionScoped
public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Student> studentsList;
	private int totalStudent;

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	@ManagedProperty(value = "#{paginator}")
	private Paginator paginator;

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	@PostConstruct
	public void init() {
		totalStudent = StudentDAO.totalStudent();
		paginator.setUserLists(totalStudent);
		setUsersList();
	}

	// international
	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void changeLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
	}

	// Pagination
	public void next() {
		paginator.next();
		setUsersList();
	}

	public void prev() {
		paginator.prev();
		setUsersList();
	}

	public void firstPage() {
		paginator.firstPage();
		setUsersList();
	}

	public void lastPage() {
		paginator.lastPage();
		setUsersList();
	}

	public ArrayList<Student> getStudentsList() {
		setUsersList();
		return studentsList;
	}

	public void setUsersList() {
		studentsList = StudentDAO.getStudentList(paginator.getFromIndex(), paginator.getLimits());
	}

	

	// Crud
	public String deleteStudent(int id) throws SQLException {
		setUsersList();
		return StudentDAO.deleteStudent(id);
	}

	public String insertStudent(Student student) throws SQLException {
		
		totalStudent = StudentDAO.totalStudent();
		paginator.setUserLists(totalStudent);
		setUsersList();
		return StudentDAO.insertStudent(student);
	}

	public String updateStudent(int id) {
		return StudentDAO.getStudent(id);
	}

	public String editStudent(Student st) throws SQLException {
		return StudentDAO.editStudent(st);
	}

}