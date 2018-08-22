package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import paginator.Paginator;

@ManagedBean(name = "student_Controller")
@SessionScoped
public class Student_Controller {
	public double tongSv;
	public ArrayList<Student_Bean> arrStudent = new ArrayList<>();
	public StudentDao studentDao = new StudentDao();
	public Locale locale;

	@ManagedProperty(value = "#{paginator}")
	Paginator paginator;

	// Phân Trang

	public Paginator getPaginator() {
		return paginator;

	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public void next() {
		paginator.next();
		arrStudent = studentDao.studentList(paginator.start(), paginator.end);
		// System.out.println(paginator.start());
	}

	public void prev() {
		paginator.prev();
		arrStudent = studentDao.studentList(paginator.start(), paginator.end);
		// System.out.println(paginator.start());

	}

	public void first() {
		paginator.first();
		;
		arrStudent = studentDao.studentList(paginator.start(), paginator.end);
	}

	public void last() {
		paginator.last();
		arrStudent = studentDao.studentList(paginator.start(), paginator.end);
	}
	// Đa ngữ

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

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		tongSv = studentDao.count();
		paginator.pagination(tongSv);
		arrStudent = studentDao.studentList(paginator.start(), paginator.end);
	}

	public ArrayList<Student_Bean> studentList() {
		arrStudent = studentDao.studentList(paginator.start(), paginator.end);
		return arrStudent;
	}

	public String deleteStudent(int id) {
		System.out.println("xoa: " + id);
		studentDao.delete(id);
		tongSv = studentDao.count();
		paginator.pagination(tongSv);
		return "index?faces-redirect=true";
	}

	public String insertStudent(Student_Bean student) throws SQLException {
		studentDao.insert(student);
		tongSv = studentDao.count();
		paginator.pagination(tongSv);
		return "index?faces-redirect=true";
	}

	public String editStudent(int id) throws SQLException {
		System.out.println("Mã sinh viên: " + id);

		Student_Bean editRecord = new Student_Bean();

		java.util.Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();

		editRecord = studentDao.getEditRecord(id);
		sessionMapObj.put("editRecord", editRecord);

		return "editStudent?faces-redirect=true";
	}

	public String updateStudent(Student_Bean student) throws SQLException {
		studentDao.update(student);

		return "index?faces-redirect=true";
	}
}
