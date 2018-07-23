package model.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import model.dao.StudentDAO;

@ManagedBean
@SessionScoped
public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Student> studentsList;
	private int totalStudent;

	private Locale locale;

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
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
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
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
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
		String rs = StudentDAO.deleteStudent(id);
		totalStudent = StudentDAO.totalStudent();
		paginator.setUserLists(totalStudent);
		return rs;
	}

	public String insertStudent(Student student) throws SQLException {

		String result = StudentDAO.insertStudent(student);
		totalStudent = StudentDAO.totalStudent();
		paginator.setUserLists(totalStudent);
		return result;
	}

	public String updateStudent(int id) {
		return StudentDAO.getStudent(id);
	}

	public String editStudent(Student st) throws SQLException {
		return StudentDAO.editStudent(st);
	}


}