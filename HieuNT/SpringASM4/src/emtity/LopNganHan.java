package emtity;

import org.springframework.stereotype.Component;

@Component
public class LopNganHan implements Lop{
	String tenLop;

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	
	public String getThongTinLop() {
		return tenLop + "\n";
	}

}
