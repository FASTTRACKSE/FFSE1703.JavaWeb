package fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trang_thai")
public class TrangThai {
	@Id
	@Column(name="id")
	int ID;
	@Column(name="ma_trang_thai")
	int MaTT;
	@Column(name="ten_trang_thai")
	int TenTT;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getMaTT() {
		return MaTT;
	}
	public void setMaTT(int maTT) {
		MaTT = maTT;
	}
	public int getTenTT() {
		return TenTT;
	}
	public void setTenTT(int tenTT) {
		TenTT = tenTT;
	}
}
