package fasttrackse.ffse1703.fbms.entity.qlvn1;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "don_nghi")
public class QuanLyVangNghiEntity {
	@Id
	@NotEmpty
	@Column(name = "id_don")
	private String id_don;
	
	@NotEmpty
	@JoinColumn(name = "id_nv")		
	private String id_nv;
	
	@NotEmpty
	@Column(name = "id_nghi")
	private String id_nghi;
	
	@NotEmpty
	@JoinColumn(name = "ly_do")
	private Date ly_do;
	
	@NotEmpty
	@Column(name = "tg_bat_dau")
	private Date tg_bat_dau;
	
	@NotEmpty
	@Column(name = "tg_ket_thuc")
	private Date tg_ket_thuc;
	
	@NotEmpty
	@Column(name = "so_ngay_nghi")
	private String so_ngay_nghi;
	
	@NotEmpty
	@Column(name = "so_ngay_con_lai")
	private String so_ngay_con_lai;
	
	@NotEmpty
	@JoinColumn(name = "tinh_trang")
	private String tinh_trang;
	
	public String getId_don() {
		return id_don;
	}
	
	public void setId_don(String id_don) {
		this.id_don = id_don;
	}
	
	public String getId_nv() {
		return id_nv;
	}
	
	public void setId_nv(String id_nv) {
		this.id_nv = id_nv;
	}
	
	public String getId_nghi() {
		return id_nghi;
	}
	
	public void setId_nghi(String id_nghi) {
		this.id_nghi = id_nghi;
	}
	
	public Date getTg_bat_dau() {
		return tg_bat_dau;
	}
	
	public void setTg_bat_dau(Date tg_bat_dau) {
		this.tg_bat_dau = tg_bat_dau;
	}
	
	public Date getTg_ket_thuc() {
		return tg_ket_thuc;
	}
	
	public void setTg_ket_thuc(Date tg_ket_thuc) {
		this.tg_ket_thuc = tg_ket_thuc;
	}
	
	public String getSo_ngay_nghi() {
		return so_ngay_nghi;
	}
	
	public void setSo_ngay_nghi(String so_ngay_nghi) {
		this.so_ngay_nghi = so_ngay_nghi;
	}
	
	public String getSo_ngay_con_lai() {
		return so_ngay_con_lai;
	}
	
	public void setSo_ngay_con_lai(String so_ngay_con_lai) {
		this.so_ngay_con_lai = so_ngay_con_lai;
	}
	
	public String getTinh_trang() {
		return tinh_trang;
	}
	
	public void setTinh_trang(String tinh_trang) {
		this.tinh_trang = tinh_trang;
	}
	
	public Date getLy_do() {
		return ly_do;
	}
	
	public void setLy_do(Date ly_do) {
		this.ly_do = ly_do;
	}
}
