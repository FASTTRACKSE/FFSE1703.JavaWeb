package bean;

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

import paginator.Paginator;

@ManagedBean(name= "student_Controller")
@SessionScoped
public class Student_Controller {
	public double tongSv;
	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	public ArrayList<Student_Bean> arrStudent = new ArrayList<>();
	public StudentDao studentDao = new StudentDao();
	
	
	@ManagedProperty(value= "#{paginator}")
	Paginator paginator;
	
//	Phân Trang

	public Paginator getPaginator() {
		return paginator;
		
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	
	public void next() {
		paginator.next();
		arrStudent = studentDao.studentList(paginator.start(),paginator.end);
		//System.out.println(paginator.start());
	}
	
	public void prev() {
		paginator.prev();
		arrStudent = studentDao.studentList(paginator.start(),paginator.end);
		//System.out.println(paginator.start());
		
	}
	
	public void first() {
		paginator.first();;
		arrStudent = studentDao.studentList(paginator.start(),paginator.end);
	}
	
	public void last() {
		paginator.last();
		arrStudent = studentDao.studentList(paginator.start(),paginator.end);
	}
	@PostConstruct
	public void init() {
		tongSv = studentDao.count();
		paginator.pagination(tongSv);
		arrStudent = studentDao.studentList(paginator.start(),paginator.end);
	}
	
	public ArrayList<Student_Bean> studentList(){
		arrStudent = studentDao.studentList(paginator.start(),paginator.end);
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
		studentDao.editRecord(id);
		System.out.println("Mã sinh viên: " + id);
		return "edit?faces-redirect=true";
	}
	
	public String updateStudent(Student_Bean student) throws SQLException {
		studentDao.update(student);
		
		return "index?faces-redirect=true";
	}
	// validate trùng mã sinh viên
			public void validate(FacesContext facesContext, UIComponent component, Object value) throws ValidatorException {
				int exist = studentDao.checkExist(value.toString());
				if(exist == 1) {
//					System.out.println(sinhVienDao.checkExist(value.toString()) + "là số lượng");
//					System.out.println(value.toString());
					FacesMessage msg = new FacesMessage("Mã sinh viên đã tồn tại. Vui lòng nhập lại");
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
					throw new ValidatorException(msg);
				}
			} 		
}
