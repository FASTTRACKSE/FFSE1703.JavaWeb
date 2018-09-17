package fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "quan_ly_nhiem_vu")
public class QLyNhiemVuEntity {
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	@NotEmpty
	private int ID;

	@Column(name = "du_an", nullable = false, length = 50)
	@NotEmpty
	private String duAn;
	
	@Column(name = "loai_cong_viec", nullable = false, length = 50)
	@NotEmpty
	private String loaiCongviec;
	
	@Column(name = "ten_cong_viec", nullable = false, length = 50)
	@NotEmpty
	private String tenCongviec;
	
	@Column(name = "mo_ta", nullable = false, length = 50)
	@NotEmpty
	private String moTa;
	
	@Column(name = "tg_bat_dau", nullable = false)
	@NotEmpty
	private String tgBatdau;
	
	@Column(name = "tg_ket_thuc", nullable = false)
	@NotEmpty
	private String tgKetthuc;
	
	@Column(name = "nguoi_duoc_phan_cong", nullable = false, length = 50)
	@NotEmpty
	private String nguoiDuocphancong;
	
	@Column(name = "tg_du_kien_hoan_thanh", nullable = false)
	@NotEmpty
	private String tgDukienhoanthanh;
	
	@Column(name = "loai_trang_thai", nullable = false, length = 50)
	@NotEmpty
	private String loaiTrangthai;
	
	@Column(name = "is_delete", nullable = false, length = 50)
	@NotEmpty
	private String isDelete;
	
	
	
public QLyNhiemVuEntity(){
	
		}



public int getID() {
	return ID;
}



public void setID(int iD) {
	ID = iD;
}



public String getDuAn() {
	return duAn;
}



public void setDuAn(String duAn) {
	this.duAn = duAn;
}



public String getLoaiCongviec() {
	return loaiCongviec;
}



public void setLoaiCongviec(String loaiCongviec) {
	this.loaiCongviec = loaiCongviec;
}



public String getTenCongviec() {
	return tenCongviec;
}



public void setTenCongviec(String tenCongviec) {
	this.tenCongviec = tenCongviec;
}



public String getMoTa() {
	return moTa;
}



public void setMoTa(String moTa) {
	this.moTa = moTa;
}



public String getTgBatdau() {
	return tgBatdau;
}



public void setTgBatdau(String tgBatdau) {
	this.tgBatdau = tgBatdau;
}



public String getTgKetthuc() {
	return tgKetthuc;
}



public void setTgKetthuc(String tgKetthuc) {
	this.tgKetthuc = tgKetthuc;
}



public String getNguoiDuocphancong() {
	return nguoiDuocphancong;
}



public void setNguoiDuocphancong(String nguoiDuocphancong) {
	this.nguoiDuocphancong = nguoiDuocphancong;
}



public String getTgDukienhoanthanh() {
	return tgDukienhoanthanh;
}



public void setTgDukienhoanthanh(String tgDukienhoanthanh) {
	this.tgDukienhoanthanh = tgDukienhoanthanh;
}



public String getLoaiTrangthai() {
	return loaiTrangthai;
}



public void setLoaiTrangthai(String loaiTrangthai) {
	this.loaiTrangthai = loaiTrangthai;
}



public String getIsDelete() {
	return isDelete;
}



public void setIsDelete(String isDelete) {
	this.isDelete = isDelete;
}


	
}
