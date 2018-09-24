package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Entity
@Table(name = "qlda_project")
public class Projects {
	@Id
	@Column(name = "id_project")
	private String idProject;

	@Column(name = "name_project")
	private String nameProject;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;

	@Column(name = "end_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	@Column(name = "project_detail")
	private String detail;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_customer", nullable = false)
	private KhachHang khachHang;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ma_phong_ban", nullable = false)
	private PhongBan roomProject;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_status", nullable = false)
	private Status status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_doamin", nullable = false)
	private Domain domain;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "qlda_technical_project", joinColumns = {
	@JoinColumn(name = "id_technical") }, inverseJoinColumns = { @JoinColumn(name = "id_project") })
	private Set<Technical> technical = new HashSet<Technical>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "qlda_database_project", joinColumns = {
	@JoinColumn(name = "id_database") }, inverseJoinColumns = { @JoinColumn(name = "id_project") })
	private Set<Database> database = new HashSet<Database>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "qlda_framework_project", joinColumns = {
	@JoinColumn(name = "id_framework") }, inverseJoinColumns = { @JoinColumn(name = "id_project") })
	private Set<Framework> framework = new HashSet<Framework>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "qlda_prolanguage_project", joinColumns = {
	@JoinColumn(name = "id_prolanguage") }, inverseJoinColumns = { @JoinColumn(name = "id_project") })
	private Set<Language> language = new HashSet<Language>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "qlda_vendor_project", joinColumns = {
	@JoinColumn(name = "id_vendor") }, inverseJoinColumns = { @JoinColumn(name = "id_project") })
	private Set<Vendor> vendor = new HashSet<Vendor>();
	
	@Column(name="isdelete")
	private int isDelete;

	public String getIdProject() {
		return idProject;
	}

	public void setIdProject(String idProject) {
		this.idProject = idProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public PhongBan getRoomProject() {
		return roomProject;
	}

	public void setRoomProject(PhongBan roomProject) {
		this.roomProject = roomProject;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Set<Technical> getTechnical() {
		return technical;
	}

	public void setTechnical(Set<Technical> technical) {
		this.technical = technical;
	}

	public Set<Database> getDatabase() {
		return database;
	}

	public void setDatabase(Set<Database> database) {
		this.database = database;
	}

	public Set<Framework> getFramework() {
		return framework;
	}

	public void setFramework(Set<Framework> framework) {
		this.framework = framework;
	}

	public Set<Language> getLanguage() {
		return language;
	}

	public void setLanguage(Set<Language> language) {
		this.language = language;
	}

	public Set<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(Set<Vendor> vendor) {
		this.vendor = vendor;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
	
}
