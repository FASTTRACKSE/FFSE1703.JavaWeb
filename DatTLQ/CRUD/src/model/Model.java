package model;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import dao.StudentDAO;

@ManagedBean
@RequestScoped
public class Model {
	private int id;
	private String firstName;
	private String txtName;
	private String txtDate;
	private String txtSex;
	private String email;
	private String sdt;
	private String diaChi;
	private String txtLop;
	private List studentsList;
	public ArrayList<Model> arrStudent;

	@ManagedProperty(value = "#{paginator}")
	private Paginator paginator;

	public Model() {
		//
	}

	public Model(int id, String firstName, String txtName, String txtDate, String txtSex, String email, String sdt,
			String diaChi, String txtLop) {
		this.id = id;
		this.firstName = firstName;
		this.txtName = txtName;
		this.txtDate = txtDate;
		this.txtSex = txtSex;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.txtLop = txtLop;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}

	public String getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(String txtDate) {
		this.txtDate = txtDate;
	}

	public String getTxtSex() {
		return txtSex;
	}

	public void setTxtSex(String txtSex) {
		this.txtSex = txtSex;
	}

	public String getTxtLop() {
		return txtLop;
	}

	public void setTxtLop(String txtLop) {
		this.txtLop = txtLop;
	}

	@PostConstruct
	public void init() {
		int countRecords = StudentDAO.countRecords();
		paginator.setUserList(countRecords);
		setUsersList();
	}

	public ArrayList<Model> studentsList() {
		// arrStudent = StudentDAO.listAllStudent();
		setUsersList();
		return arrStudent;
	}

	public String insertStudent(Model sv) throws SQLException {

		return StudentDAO.addSV(sv);
	}

	public String updateStudent(int id) {
		return StudentDAO.getStuByID(id);
	}

	public String editStudent(Model sv) throws SQLException {
		return StudentDAO.repCus(sv);
	}

	public String deleteStudent(int id) throws SQLException {
		return StudentDAO.delCus(id);
	}

	public void setUsersList() {
		this.arrStudent = (ArrayList<Model>) StudentDAO.listStudentPage(paginator.getFromIndex(),
				paginator.getRecords());
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

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
}
