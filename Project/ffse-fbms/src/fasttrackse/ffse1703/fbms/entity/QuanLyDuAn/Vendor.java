package fasttrackse.ffse1703.fbms.entity.QuanLyDuAn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "doi_tac")
public class Vendor {
	@Id
	@NotEmpty
	@Column(name = "ma_doi_tac")
	 String mavd;
	
	@Column(name = "ten_doi_tac")
	@NotEmpty
	 String tenvd;
	
	@Column(name = "dia_chi")
	@NotEmpty
	 String diachi;
	
	@Column(name = "so_dien_thoai")
	@NotEmpty
	 String sdt;
	
	@Column(name = "email")
	@NotEmpty
	 String email;

	
	@Column(name = "is_delete")
	
	 int isDelete;


	public String getMavd() {
		return mavd;
	}


	public void setMavd(String mavd) {
		this.mavd = mavd;
	}


	public String getTenvd() {
		return tenvd;
	}


	public void setTenvd(String tenvd) {
		this.tenvd = tenvd;
	}


	public String getDiachi() {
		return diachi;
	}


	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getIs_delete() {
		return isDelete;
	}


	public void setIs_delete(int is_delete) {
		this.isDelete = is_delete;
	}
	

}
