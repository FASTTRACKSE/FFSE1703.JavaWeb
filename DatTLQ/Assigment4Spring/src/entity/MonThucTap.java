package entity;

import org.springframework.stereotype.Component;

@Component
public class MonThucTap implements MonHoc {
	private String tenCompany;
	private GiangVien tenGV;
	
	public String getTenCompany() {
		return tenCompany;
	}

	public void setTenCompany(String tenCompany) {
		this.tenCompany = tenCompany;
	}

	public GiangVien getTenGV() {
		return tenGV;
	}

	public void setTenGV(GiangVien tenGV) {
		this.tenGV = tenGV;
	}

	public String thongTinMonHoc() {
		String kq=tenCompany +"\n + Tên Giảng Viên:" + tenGV.getGiangVien();
	
		return null;
	}

}
