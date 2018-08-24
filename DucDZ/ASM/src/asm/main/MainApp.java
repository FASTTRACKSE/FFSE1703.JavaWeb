package asm.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import asm.entity.DaoTaoDaiHan;
import asm.entity.DaoTaoNganHan;
import asm.entity.GiangVien;
import asm.entity.HocKy;
import asm.entity.HocKy1;
import asm.entity.HocKy2;
import asm.entity.HocKy3;
import asm.entity.HocKy4;
import asm.entity.HocKyJava;
import asm.entity.HocKyWebFullStack;
import asm.entity.LopHoc;
import asm.entity.MonCongNghe;
import asm.entity.MonHoc;
import asm.entity.MonThucTap;
import asm.entity.MonTiengAnh;
import asm.entity.SinhVien;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext conText = new ClassPathXmlApplicationContext("appContext.xml");
		List<LopHoc> lopHoc = new ArrayList<>();
		List<HocKy> hocKy = new ArrayList<>();
		List<SinhVien> listSV = new ArrayList<>();

		GiangVien gvThanh = new GiangVien("Thành", "thanhcl@gmail.com");
		GiangVien gvLam = new GiangVien("Lâm", "ngvlam@gmail.com");
		GiangVien gvThang = new GiangVien("Thắng", "thang@gmail.com");
		GiangVien gvHong = new GiangVien("Hồng", "hong@gmail.com");
		GiangVien gvQuyen = new GiangVien("Quyên", "quyen@gmail.com");
		GiangVien gvHuong = new GiangVien("Hương", "huong@gmail.com");

		List<MonHoc> monCNhk1 = new ArrayList<>();
		List<MonHoc> monTAhk1 = new ArrayList<>();
		monCNhk1.add(new MonCongNghe("HTML", gvThanh, gvThang, gvLam));
		monCNhk1.add(new MonCongNghe("CSS", gvThanh, gvThang, gvLam));
		monCNhk1.add(new MonCongNghe("PHP", gvThang, gvThanh, gvLam));
		monTAhk1.add(new MonTiengAnh("English Basic", "level 1", gvHong, gvQuyen));
		monTAhk1.add(new MonTiengAnh("E4IT", "level 1", gvHong, gvQuyen));
		hocKy.add(new HocKy1(monCNhk1, monTAhk1));

		List<MonHoc> monCNhk2 = new ArrayList<>();
		List<MonHoc> monTAhk2 = new ArrayList<>();
		monCNhk2.add(new MonCongNghe("Java Core", gvThanh, gvThang, gvLam));
		monCNhk2.add(new MonCongNghe("Java Desktop", gvThanh, gvThang, gvLam));
		monTAhk2.add(new MonTiengAnh("E4IT", "level 2", gvHong, gvHuong));
		monTAhk2.add(new MonTiengAnh("Very Easy Toeic", "level 2", gvHong, gvHuong));
		hocKy.add(new HocKy2(monCNhk2, monTAhk2));

		List<MonHoc> monCNhk3 = new ArrayList<>();
		monCNhk3.add(new MonCongNghe("Android Application", gvThanh, gvThang, gvLam));
		monCNhk3.add(new MonCongNghe("IoT", gvThanh, gvThang, gvLam));
		hocKy.add(new HocKy3(monCNhk3));

		List<MonHoc> monThucTap = new ArrayList<>();
		monThucTap.add(new MonThucTap("Fsoft", gvThang));
		monThucTap.add(new MonThucTap("Fpoly", gvThanh));
		hocKy.add(new HocKy4(monThucTap));

		List<MonHoc> monCNjava = new ArrayList<>();
		monCNjava.add(new MonCongNghe("Java Core", gvThang, gvThanh, gvLam));
		monCNjava.add(new MonCongNghe("Java Web", gvThanh, gvThang, gvLam));
		HocKyJava hkJava = new HocKyJava(monCNjava);

		List<MonHoc> monCNwebfull = new ArrayList<>();
		monCNwebfull.add(new MonCongNghe("HTML", gvThanh, gvThang, gvLam));
		monCNwebfull.add(new MonCongNghe("CSS", gvThanh, gvThang, gvLam));
		monCNwebfull.add(new MonCongNghe("PHP", gvThang, gvThanh, gvLam));
		HocKyWebFullStack hkWebFull = new HocKyWebFullStack(monCNwebfull);

		List<SinhVien> sinhVien = new ArrayList<>();
		for (int i = 0; i <= 20; i++) {
			sinhVien.add(new SinhVien("Pham Tran " + i, i + "@gmail.com", "so nha " + i, "012345" + i));
		}
		List<SinhVien> svlop1703 = new ArrayList<>();
		svlop1703 = sinhVien.subList(0, 5);
		lopHoc.add(new LopHoc("1703", new DaoTaoDaiHan(hocKy), svlop1703));

		List<SinhVien> svlop1704 = new ArrayList<>();
		svlop1704 = sinhVien.subList(6, 9);
		lopHoc.add(new LopHoc("1704", new DaoTaoDaiHan(hocKy), svlop1704));

		List<SinhVien> svlop1801 = new ArrayList<>();
		svlop1801 = sinhVien.subList(10, 15);
		lopHoc.add(new LopHoc("1801", new DaoTaoNganHan(hocKy), svlop1801));

		List<SinhVien> svlop1802 = new ArrayList<>();
		svlop1802 = sinhVien.subList(16, 20);
		lopHoc.add(new LopHoc("1802", new DaoTaoNganHan(hocKy), svlop1802));
		
		for(LopHoc lh : lopHoc) {
			System.out.println(lh.infoLopHoc());
		}
		conText.close();
	}
}
