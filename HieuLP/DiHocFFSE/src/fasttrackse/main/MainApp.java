package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import fasttrackse.entity.*;
import fasttrackse.entity.SinhVienVersion5;

public class MainApp {

	public static void main(String[] args) {
		SinhVienVersion5 sinhVien1 = new SinhVienVersion5("Phước Hiếu");
		sinhVien1.setHeDaotao(new KhoaDaiHan());
		System.out.println(sinhVien1.khoaDaoTao());
		//System.out.println(sinhVien1.mangSachDiHoc());
		
		
		
		
		SinhVienVersion5 sinhVien2 = new SinhVienVersion5("Thanh Danh");
		sinhVien2.setHeDaotao(new KhoaNganHan());
		System.out.println(sinhVien2.khoaDaoTao());
		
	//	sinhvien1.setMonHoc(new MonHoc());
		
		
		
		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		
		monHoc1.add(new MonToan());
		monHoc1.add(new MonLy());
		
		monHoc2.add(new English());
	}
	

}
