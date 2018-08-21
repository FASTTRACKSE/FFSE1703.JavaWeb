package annotation.main;

import java.util.ArrayList;
import annotation.entity.DaoTaoDaiHan;
import annotation.entity.DaoTaoNganHan;
import annotation.entity.MonHoa;
import annotation.entity.MonHoc;
import annotation.entity.MonLy;
import annotation.entity.MonToan;
import annotation.entity.SinhVien;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien sv1 = new SinhVien("Duc DZ", new DaoTaoNganHan());
		SinhVien sv2 = new SinhVien();
		sv2.setHdt(new DaoTaoDaiHan());
		sv2.setHoTen("Duc dz");
		ArrayList<MonHoc> mh1 = new ArrayList<MonHoc>();
		ArrayList<MonHoc> mh2 = new ArrayList<MonHoc>();
		mh1.add(new MonLy());
		mh1.add(new MonHoa());
		mh2.add(new MonToan());
		sv1.setMh(mh1);
		sv2.setMh(mh2);
		System.out.println(sv1.mangSach());
		System.out.println(sv2.mangSach());
	}

}
