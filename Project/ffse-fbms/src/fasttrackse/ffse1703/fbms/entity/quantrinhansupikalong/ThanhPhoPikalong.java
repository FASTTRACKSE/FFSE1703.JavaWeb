package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TinhThanh")
public class ThanhPhoPikalong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maTinhThanh;
	
	private String tenTinhThanh;

	public int getMaTinhThanh() {
		return maTinhThanh;
	}

	public void setMaTinhThanh(int maTinhThanh) {
		this.maTinhThanh = maTinhThanh;
	}

	public String getTenTinhThanh() {
		return tenTinhThanh;
	}

	public void setTenTinhThanh(String tenTinhThanh) {
		this.tenTinhThanh = tenTinhThanh;
	}
	
	
}
