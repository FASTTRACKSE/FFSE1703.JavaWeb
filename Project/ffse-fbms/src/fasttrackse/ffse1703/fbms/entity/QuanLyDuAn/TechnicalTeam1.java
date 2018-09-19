package fasttrackse.ffse1703.fbms.entity.QuanLyDuAn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cong_nghe")
public class TechnicalTeam1 {
	@Id
	@Column(name = "ma_cong_nghe")
	private String ma_cong_nghe;

	@Column(name = "ten_cong_nghe")
	private String ten_cong_nghe;

	@Column(name = "is_delete")
	private int is_delete;

	public String getMa_cong_nghe() {
		return ma_cong_nghe;
	}

	public void setMa_cong_nghe(String ma_cong_nghe) {
		this.ma_cong_nghe = ma_cong_nghe;
	}

	public String getTen_cong_nghe() {
		return ten_cong_nghe;
	}

	public void setTen_cong_nghe(String ten_cong_nghe) {
		this.ten_cong_nghe = ten_cong_nghe;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

}
