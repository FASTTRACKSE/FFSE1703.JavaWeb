package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import fasttrackse.entity.*;
import fasttrackse.entity.SinhVienVersion5;

public class MainApp {

	public static void main(String[] args) {
	SinhVienVersion5 sinhVien1 = new SinhVienVersion5("Thành", new KhoaDaiHan());
		
		SinhVienVersion5 sinhVien2 = new SinhVienVersion5("Hồng");
		// Inject HeDaoTao qua hàm setter
		sinhVien2.setHeDaoTao(new KhoaNganHan());
		
		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		
		monHoc1.add(new MonToan());
		monHoc1.add(new MonLy());
	
		
		monHoc2.add(new English());


		// Inject MonHoc qua hàm setter
		sinhVien1.setMonHoc(monHoc1);
		sinhVien2.setMonHoc(monHoc2);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
	}
	

}
