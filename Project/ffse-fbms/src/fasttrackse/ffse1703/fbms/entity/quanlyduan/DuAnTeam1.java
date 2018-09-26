package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="du_an")
public class DuAnTeam1 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty
	@Column(name="ma_du_an")
	private String maDuAn;
	
	@Column(name="ten_du_an")
	@NotEmpty
	@Length(min=5,max=200)
	private String tenDuAn;
	
	@Column(name="mo_ta_du_an")
	@NotEmpty
	private String moTaDuAn;
	

	@Column(name="is_delete")
	private int isDelete;
	
	@Column (name="start_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date startDate;
	
	@Column (name="end_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date endDate;
	
	@ManyToMany(targetEntity = DatabaseTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "database_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_database", referencedColumnName = "ma_database", nullable = true, updatable = false,insertable=true) })
	@NotEmpty
	private Set<DatabaseTeam1> database;

	@ManyToMany(targetEntity = TechnicalTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cong_nghe_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_cong_nghe", referencedColumnName = "ma_cong_nghe", nullable = true, updatable = false,insertable=true) })
	@NotEmpty
	private Set<TechnicalTeam1> Technical;
	
	@ManyToMany(targetEntity = FrameworkTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "framework_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_framework", referencedColumnName = "ma_framework", nullable = true, updatable = false,insertable=true) })
	@NotEmpty
	private Set<FrameworkTeam1> Framework;
	
	@ManyToMany(targetEntity = VendorTeam1.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "doi_tac_du_an", joinColumns = {
	@JoinColumn(name = "ma_du_an", referencedColumnName = "ma_du_an",  updatable = true,insertable=true) }, inverseJoinColumns = {
	@JoinColumn(name = "ma_doi_tac", referencedColumnName = "ma_doi_tac", nullable = true, updatable = false,insertable=true) })
	@NotEmpty
	private Set<VendorTeam1> Vendor;


	public Set<VendorTeam1> getVendor() {
		return Vendor;
	}

	public void setVendor(Set<VendorTeam1> vendor) {
		Vendor = vendor;
	}

	public Set<FrameworkTeam1> getFramework() {
		return Framework;
	}

	public void setFramework(Set<FrameworkTeam1> framework) {
		Framework = framework;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name="ma_khach_hang",referencedColumnName="ma_khach_hang", insertable=true, updatable=true)
	@NotNull
	private KhachHangTeam1 khachHang  ;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name="ma_tinh_trang",referencedColumnName="ma_tinh_trang", insertable=true, updatable=true)
	@NotNull
	private TrangThaiTeam1 TrangThai;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name="ma_nghiep_vu",referencedColumnName="ma_nghiep_vu", insertable=true, updatable=true)
	@NotNull
	private DomainTeam1 Domain;	
	
	public DomainTeam1 getDomain() {
		return Domain;
	}
	public Set<TechnicalTeam1> getTechnical() {
		return Technical;
	}

	public void setTechnical(Set<TechnicalTeam1> technical) {
		Technical = technical;
	}

	public void setDomain(DomainTeam1 domain) {
		Domain = domain;
	}

	public TrangThaiTeam1 getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(TrangThaiTeam1 trangThai) {
		TrangThai = trangThai;
	}

	public KhachHangTeam1 getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangTeam1 khachHang) {
		this.khachHang = khachHang;
	}

	public String getMaDuAn() {
		return maDuAn;
	}

	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}

	public Set<DatabaseTeam1> getDatabase() {
		return database;
	}

	public void setDatabase(Set<DatabaseTeam1> database) {
		this.database = database;
	}

	public String getTenDuAn() {
		return tenDuAn;
	}

	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public String getMoTaDuAn() {
		return moTaDuAn;
	}

	public void setMoTaDuAn(String moTaDuAn) {
		this.moTaDuAn = moTaDuAn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
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

}
