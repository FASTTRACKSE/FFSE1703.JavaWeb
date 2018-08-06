package sv.main;

import java.util.ArrayList;
import java.util.List;

import sv.model.DaoTaoDaiHan;
import sv.model.DaoTaoNganHan;
import sv.model.MonHoc;
import sv.model.MonLy;
import sv.model.MonToan;
import sv.model.MonVan;
import sv.model.SinhVienVersion2;

public class MainAppVer2 {
	
	public static void main(String[] args) {
		
		SinhVienVersion2 sinhVien2 = new SinhVienVersion2("Tuấn");
		sinhVien2.setHeDaoTao(new DaoTaoNganHan());
		
		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		
		monHoc1.add(new MonToan());
		monHoc1.add(new MonLy());
		monHoc1.add(new MonVan());
		
		sinhVien2.setMonHoc(monHoc1);
		System.out.print( sinhVien2.diHoc());
		
		
		
		monHoc2.add(new MonToan());
		SinhVienVersion2 sinhVien1 = new SinhVienVersion2("Tâm");
		sinhVien1.setHeDaoTao(new DaoTaoDaiHan());
		sinhVien1.setMonHoc(monHoc2);
		System.out.print( sinhVien1.diHoc());
		
		
		
		
		
	}
}
