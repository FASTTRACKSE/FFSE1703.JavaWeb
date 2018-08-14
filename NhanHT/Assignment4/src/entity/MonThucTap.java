package entity;

import org.springframework.stereotype.Component;

@Component
public class MonThucTap implements MonHoc {
	private String tenMonHoc;
	public MonThucTap() {
		// TODO Auto-generated constructor stub
	}

	public MonThucTap(String tenMonHoc) {
		super();
		this.tenMonHoc = tenMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	@Override
	public String thongTinMonHoc() {
		// TODO Auto-generated method stub
		return tenMonHoc;
	}

}
