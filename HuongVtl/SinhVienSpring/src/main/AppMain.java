package main;

import bean.*;

public class AppMain {
	public static void main(String[] args) {
		LopHoc ffse1703 = new LopHoc();
		ffse1703.setTenLop("ffse1703");
		ffse1703.setHeDaoTao(new TenHeDaoTao("đào tạo dài hạn"));
		ffse1703.setMonHoc(new TenMonHoc("toán", "thầy A"));
		ffse1703.setTenSv(new SinhVien("H"));
		ffse1703.inThongTin();
	}
}
 