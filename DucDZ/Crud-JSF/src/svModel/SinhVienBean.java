package svModel;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import svModel.Pagination;
import svOperation.svDao;

@ManagedBean(name="svBean")
@RequestScoped
public class SinhVienBean {

	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String address;
	private ArrayList<SinhVienBean> svListFromDB = new ArrayList<SinhVienBean>();
	@ManagedProperty(value="#{pagination}")
	public Pagination pagination;
	@PostConstruct
	public void init() {
		int countRecords = svDao.countRecords();
		pagination.setSVList(countRecords);
		this.svListFromDB = svDao.getSVListFromDB(pagination.getFromIndex(),
				pagination.getRecord());
	}
	public SinhVienBean () {
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
	public ArrayList<SinhVienBean> getSvListFromDB() {
		svListFromDB = svDao.getSVListFromDB(pagination.getFromIndex(),pagination.getRecord());
		return svListFromDB;
	}
	public void next() {
		pagination.next();
		this.svListFromDB = svDao.getSVListFromDB(pagination.getFromIndex(),pagination.getRecord());
	}
	public void prev() {
		pagination.prev();
		this.svListFromDB = svDao.getSVListFromDB(pagination.getFromIndex(),pagination.getRecord());
	}
	public void firstPage() {
		pagination.firstPage();
		this.svListFromDB = svDao.getSVListFromDB(pagination.getFromIndex(),pagination.getRecord());
	}
	public void lastPage() {
		pagination.lastPage();
		this.svListFromDB = svDao.getSVListFromDB(pagination.getFromIndex(),pagination.getRecord());
	}
	public void setSvListFromDB(ArrayList<SinhVienBean> svListFromDB) {
		this.svListFromDB = svListFromDB;
	}
	public String saveSVDetails(SinhVienBean newSV) throws SQLException {
		return svDao.saveSVDetailsInDB(newSV);
	}
	public String editSVRecord(int svID) throws SQLException {
		return svDao.editSVRecordInDB(svID);
	}
	public String updateSVDetails(SinhVienBean updateSV) {
		return svDao.updateSVDetailsInDB(updateSV);
	}
	public String deleteSVRecord(int svID) throws SQLException {
		return svDao.deleteSVRecordInDB(svID);
	}
}
