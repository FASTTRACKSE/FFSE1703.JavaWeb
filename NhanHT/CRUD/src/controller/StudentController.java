package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.StudentBean;
import dao.StudentDAO;

@ManagedBean
@SessionScoped
public class StudentController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int trang;
	private double soTrang;
	public ArrayList<StudentBean> studentsListFromDB;
	public StudentDAO studentDAO = new StudentDAO();
	public double tongSv;
	@ManagedProperty(value = "#{paginator}")
	Paginator paginator;
	// 
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

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
	//
	public String deleteStudentRecord(int studentId) throws SQLException {
		String st = studentDAO.deleteStudentRecordInDB(studentId);
		tongSv = studentDAO.countSv();
		paginator.paginator(tongSv);
		return st;
	}

	public String saveStudentDetails(StudentBean newStudentObj) throws SQLException {
		String st = studentDAO.insertStudentDetailsInDB(newStudentObj);
		double tongSv = studentDAO.countSv();
		paginator.paginator(tongSv);
		return st;
	}

	public String editStudentRecord(int studentId) throws SQLException {
		return studentDAO.editStudentRecordInDB(studentId);
	}

	public String updateStudentDetails(StudentBean updateStudentObj) throws SQLException {
		return studentDAO.updateStudentDetailsInDB(updateStudentObj);
	}

	public int getTrang() {
		return trang;
	}

	public void setTrang(int trang) {
		this.trang = trang;
	}

	public double getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(double soTrang) {
		this.soTrang = soTrang;
	}

	@PostConstruct
	public void init() {
		try {
			tongSv = studentDAO.countSv();
			paginator.paginator(tongSv);
			studentsListFromDB = studentDAO.getStudentsListFromDB(paginator.start(), paginator.end);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// paginator
	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public void next() throws SQLException {
		paginator.next();
		studentsListFromDB = studentDAO.getStudentsListFromDB(paginator.start(), paginator.end);
	}

	public void prev() throws SQLException {
		paginator.prev();
		studentsListFromDB = studentDAO.getStudentsListFromDB(paginator.start(), paginator.end);

	}

	public void first() throws SQLException {
		paginator.first();
		studentsListFromDB = studentDAO.getStudentsListFromDB(paginator.start(), paginator.end);
	}

	public void last() throws SQLException {
		paginator.last();
		studentsListFromDB = studentDAO.getStudentsListFromDB(paginator.start(), paginator.end);
	}

	public ArrayList<StudentBean> studentsList() throws SQLException {
		studentsListFromDB = studentDAO.getStudentsListFromDB(paginator.start(), paginator.end);
		return studentsListFromDB;
	}
}
