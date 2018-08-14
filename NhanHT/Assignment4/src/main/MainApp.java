package main;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.GiangVienSV;
import entity.HeDaiHanFTSE;
import entity.HeNganHanFTSE;
import entity.HocKy;
import entity.HocKy1;
import entity.HocKy2;
import entity.HocKy3;
import entity.HocKy4;
import entity.HocKyJava;
import entity.LopHoc;
import entity.MonCongNghe;
import entity.MonThucTap;
import entity.MonTiengAnh;
import entity.SinhVien;

public class MainApp {
	public static ArrayList<HocKy> hocky = new ArrayList<>();
	public static ArrayList<MonCongNghe> monCongNghe = new ArrayList<>();
	public static ArrayList<MonTiengAnh> monTiengAnh =  new ArrayList<>();
	public static ArrayList<MonThucTap> monThucTap =  new ArrayList<>();
	public static ArrayList<SinhVien> sinhVien = new ArrayList<>();
	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static void main(String[] args) {
		sinhVien.add(new SinhVien("Nguyễn Văn A", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		sinhVien.add(new SinhVien("Nguyễn Văn B", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		sinhVien.add(new SinhVien("Nguyễn Văn C", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		sinhVien.add(new SinhVien("Nguyễn Văn D", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		
		
		
		LopHoc lop1703 = (LopHoc) context.getBean("lopHoc");
		lop1703.setTenLop("Lớp FFSE1703");
		lop1703.setSinhVien(sinhVien);
		GiangVienSV GVThanh = new GiangVienSV("Thầy Thành", "Fasttrack@edu.vn");
		GiangVienSV GVLam = new GiangVienSV("Thầy Lâm", "Fasttrack@edu.vn");
		GiangVienSV GVThang = new GiangVienSV("Thầy Thắng", "Fasttrack@edu.vn");
		GiangVienSV GVHong = new GiangVienSV("Cô Hồng", "Fasttrack@edu.vn");
		GiangVienSV GVQuyen = new GiangVienSV("Cô Quyên", "Fasttrack@edu.vn");
		GiangVienSV GVHuong = new GiangVienSV("Cô Hương", "Fasttrack@edu.vn");
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		monTiengAnh.add(new MonTiengAnh(GVHong,GVQuyen, "Tiếng Anh Level 1"));
		monTiengAnh.add(new MonTiengAnh(GVHong,GVQuyen, "Tiếng Anh Level 2"));
		monTiengAnh.add(new MonTiengAnh(GVHong,GVQuyen, "Tiếng Anh Level 3"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam, "JAVA"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"HTML"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"CSS"));
		hocky.add(new HocKy1(monCongNghe, monTiengAnh));
		//
		monCongNghe = new ArrayList<>();
		monTiengAnh = new ArrayList<>();
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"PHP"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"C++"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"CSS"));
		monTiengAnh.add(new MonTiengAnh(GVHong,GVHuong,"Tiếng Anh Level 1"));
		monTiengAnh.add(new MonTiengAnh(GVHong,GVHuong,"Tiếng Anh Level 2"));
		monTiengAnh.add(new MonTiengAnh(GVHong,GVHuong,"Tiếng Anh Level 3"));
		hocky.add(new HocKy2(monCongNghe,monTiengAnh));
		//
		monCongNghe = new ArrayList<>();
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"C#"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"C++"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"HTML"));
		hocky.add(new HocKy3(monCongNghe));
		
		
		monThucTap = new ArrayList<>();
		monThucTap.add(new MonThucTap("FSorf"));
		monThucTap.add(new MonThucTap("FSorf"));
		monThucTap.add(new MonThucTap("FSorf"));
		hocky.add(new HocKy4(monThucTap));
		//
		lop1703.setHeDaoTaoSV(new HeDaiHanFTSE(hocky));
		lop1703.inThongTin();
		
		
		
		
		//lop 1801
		LopHoc lop1801 = (LopHoc) context.getBean("lopHoc");
		sinhVien = new ArrayList<>();
		lop1801.setTenLop("Lớp FFSE1801");
		hocky = new ArrayList<>();
		
		sinhVien.add(new SinhVien("Nguyễn Văn F", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		sinhVien.add(new SinhVien("Nguyễn Văn G", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		sinhVien.add(new SinhVien("Nguyễn Văn H", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		sinhVien.add(new SinhVien("Nguyễn Văn J", "Fasttrack@edu.vn", "Đà Nẵng", "0123456789"));
		lop1801.setSinhVien(sinhVien);
		monCongNghe = new ArrayList<>();
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam, "JAVA"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"HTML"));
		monCongNghe.add(new MonCongNghe(GVThanh, GVThang, GVLam,"CSS"));
		lop1801.setHeDaoTaoSV(new HeNganHanFTSE(new HocKyJava(monCongNghe)));
		lop1801.inThongTin();
	}

}
