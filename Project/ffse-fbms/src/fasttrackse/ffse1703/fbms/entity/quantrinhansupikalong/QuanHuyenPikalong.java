package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "QuanHuyen")
public class QuanHuyenPikalong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maQuanHuyen;
	
	private String tenQuanHuyen;
	
	private int maTinhThanh;

	public int getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(int maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}

	public String getTenQuanHuyen() {
		return tenQuanHuyen;
	}

	public void setTenQuanHuyen(String tenQuanHuyen) {
		this.tenQuanHuyen = tenQuanHuyen;
	}

	public int getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(int maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}
	
	
}
