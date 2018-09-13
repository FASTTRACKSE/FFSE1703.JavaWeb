package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import emtity.DaoTaoNganHan;
import emtity.HocKy1;
import emtity.ListSinhVien;
import emtity.LopDaiHan;
import emtity.MonHoa;
import emtity.MonHoc;
import emtity.MonLy;
import emtity.MonToan;
import emtity.SinhVienNangCao;

public class MainApp {

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext1.xml");
		// Tạo bean từ spring containner
		SinhVienNangCao lop1 = context.getBean("lop", SinhVienNangCao.class);
		
		SinhVienNangCao lop2 = context.getBean("lop", SinhVienNangCao.class);


		MonToan monToan = context.getBean("monToan", MonToan.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);
		MonHoa monHoa = context.getBean("monHoa", MonHoa.class);

		DaoTaoNganHan heDaoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);

		LopDaiHan ffse1702 = context.getBean("lopDaiHan", LopDaiHan.class);

		HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);

		List<ListSinhVien> sv = new ArrayList<ListSinhVien>();
		sv.add(new ListSinhVien("cine"));
		sv.add(new ListSinhVien("nike"));

		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		monHoc1.add(monToan);
		monHoc1.add(monLy);
		monHoc1.add(monHoa);

		lop1.setLop(ffse1702);
		lop1.setHocKy(hocKy1);
		lop1.setMonHoc(monHoc1);
		lop1.setHoTen(sv);

		lop1.setHeDaoTao(heDaoTaoNganHan);

		System.out.println(lop1.Lop());

	}

}