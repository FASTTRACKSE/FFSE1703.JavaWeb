package fasttrackse.main;
import java.util.ArrayList;
import java.util.List;

import fasttrackse.entity.*;
public class MainAPPver2 {

	public static void main(String[] args) {
		// Inject HeDaoTao qua hàm construct
		SinhVienVersion5 sinhVien1 = new SinhVienVersion5("Thành", new HeDaoTaoDaiHan());
		
		SinhVienVersion5 sinhVien2 = new SinhVienVersion5("Hồng");
		// Inject HeDaoTao qua hàm setter
		sinhVien2.setHeDaoTao(new HeDaoTaoNganHang());
		
		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		
		monHoc1.add(new MonToan());
		monHoc1.add(new MonLy());
		monHoc1.add(new MonHoa());
		
		monHoc2.add(new MonAnh());
		monHoc2.add(new MonLy());

		// Inject MonHoc qua hàm setter
		sinhVien1.setMonHoc(monHoc1);
		sinhVien2.setMonHoc(monHoc2);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());
	}
}