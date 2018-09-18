package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Phuong")
public class PhuongPikalong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhuong;
	
	private String tenPhuong;
	
	private int maQuanHuyen;

	public int getMaPhuong() {
		return maPhuong;
	}

	public void setMaPhuong(int maPhuong) {
		this.maPhuong = maPhuong;
	}

	public String getTenPhuong() {
		return tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}

	public int getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(int maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}
	
	
	
}
