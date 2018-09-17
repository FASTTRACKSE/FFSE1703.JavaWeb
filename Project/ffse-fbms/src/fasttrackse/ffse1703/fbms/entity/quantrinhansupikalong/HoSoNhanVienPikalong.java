package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "ThongTinHoSo")
public class HoSoNhanVienPikalong {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNv;
	
	private String hoTenNv;
	
	private String gioiTinh;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	
	private String thanhPho;
	
	private String quanHuyen;
	
	private String phuongXa;
	
	private String noiOHienNay;
	
	private int cMND;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayCap;
	
	private String noiCap;
	
	private int sDT;
	
	private String email;
	
	private String danToc;
	
	private String quocTich;
	
	private String maChucDanh;
	
	private String maPhongBan;
	
	private String avatar;
	
	private int isActive;

	public int getMaNv() {
		return maNv;
	}

	public String getHoTenNv() {
		return hoTenNv;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public String getQuanHuyen() {
		return quanHuyen;
	}

	public String getPhuongXa() {
		return phuongXa;
	}

	public String getNoiOHienNay() {
		return noiOHienNay;
	}

	public int getcMND() {
		return cMND;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public int getsDT() {
		return sDT;
	}

	public String getEmail() {
		return email;
	}

	public String getDanToc() {
		return danToc;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public String getMaChucDanh() {
		return maChucDanh;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public String getAvatar() {
		return avatar;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setMaNv(int maNv) {
		this.maNv = maNv;
	}

	public void setHoTenNv(String hoTenNv) {
		this.hoTenNv = hoTenNv;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}

	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}

	public void setNoiOHienNay(String noiOHienNay) {
		this.noiOHienNay = noiOHienNay;
	}

	public void setcMND(int cMND) {
		this.cMND = cMND;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public void setsDT(int sDT) {
		this.sDT = sDT;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public void setMaChucDanh(String maChucDanh) {
		this.maChucDanh = maChucDanh;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	
}
