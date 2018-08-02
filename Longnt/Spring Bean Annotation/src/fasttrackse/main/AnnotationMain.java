package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import fasttrackse.entity.DaoTaoDaiHan;
import fasttrackse.entity.DaoTaoNganHan;
import fasttrackse.entity.MonHoa;
import fasttrackse.entity.MonHoc;
import fasttrackse.entity.MonLy;
import fasttrackse.entity.MonToan;
import fasttrackse.entity.SinhVien;

public class AnnotationMain {
	public static void main(String[] args) {
		// Inject HeDaoTao qua hàm construct
		SinhVien sinhVien1 = new SinhVien("Long", new DaoTaoDaiHan());
		
		SinhVien sinhVien2 = new SinhVien("Mi");
		// Inject HeDaoTao qua hàm setter
		sinhVien2.setHeDaoTao(new DaoTaoNganHan());
		
		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		
		monHoc2.add(new MonToan());
		monHoc1.add(new MonLy());
		monHoc1.add(new MonHoa());


		// Inject MonHoc qua hàm setter
		sinhVien1.setMonHoc(monHoc1);
		sinhVien2.setMonHoc(monHoc2);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
	}
}
