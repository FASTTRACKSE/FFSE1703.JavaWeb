package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.DaoTaoDaiHan;
import fasttrackse.entity.DaoTaoNganHan;
import fasttrackse.entity.GiangVien;
import fasttrackse.entity.HocKy;
import fasttrackse.entity.HocKy1;
import fasttrackse.entity.HocKy2;
import fasttrackse.entity.HocKy3;
import fasttrackse.entity.HocKy4;
import fasttrackse.entity.HocKyJava;
import fasttrackse.entity.HocKyWebFullStack;
import fasttrackse.entity.LopHoc;
import fasttrackse.entity.MonCongNghe;
import fasttrackse.entity.MonThucTap;
import fasttrackse.entity.MonTiengAnh;
import fasttrackse.entity.SinhVien;

public class MainApp {
	public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	DaoTaoDaiHan daoTaoDaiHan = context.getBean("daoTaoDaiHan",DaoTaoDaiHan.class);
	MonCongNghe monCongNghe1 = context.getBean("monCongNghe", MonCongNghe.class);
	MonTiengAnh monTiengAnh1 = context.getBean("monTiengAnh", MonTiengAnh.class);
	MonCongNghe monCongNghe2 = context.getBean("monCongNghe", MonCongNghe.class);
	MonTiengAnh monTiengAnh2 = context.getBean("monTiengAnh", MonTiengAnh.class);
	MonCongNghe monCongNghe3 = context.getBean("monCongNghe", MonCongNghe.class);
	MonThucTap monThucTap = context.getBean("monThucTap", MonThucTap.class);
	
	
	GiangVien giangVienPhuTrach = new GiangVien("Nguyễn Đình Thi.", " Địa chỉ email: TuanCL@gmail.com");
	
	
	monCongNghe1.setGiangVienChinh(new GiangVien("Lê Cao Thành.", " Địa chỉ email: ThanhCL@gmail.com"));
	monCongNghe1.setTroGiang( new GiangVien("Trần Minh Thắng.", " Địa chỉ email: ThangTM@gmail.com"));
	monCongNghe1.setMentor(new GiangVien("Lê Văn Tuấn.", " Địa chỉ email: TuanLV@gmail.com"));
	monCongNghe1.setTenMonHoc( new GiangVien("Môn: ","Nhập môn lập Trình - HTML,CSS - WebFrontEnd"));
	monTiengAnh1.setGiangVienChinh(new GiangVien("Lê Thị Mỹ Hồng."," Địa chỉ email: HongLTM@gmail.com"));
	monTiengAnh1.setTroGiang(new GiangVien("Nguyễn Thị Kiều Mi."," Địa chỉ email: MiNTK@gmail.com"));
	
	monCongNghe2.setGiangVienChinh(new GiangVien("Hồ Tấn Sinh.", " Địa chỉ email: Sinh@gmail.com"));
	monCongNghe2.setTroGiang(new GiangVien("Nguyễn Tất Thành.", " Địa chỉ email: Thanh@gmail.com"));
	monCongNghe2.setMentor(new GiangVien("Nguyễn Thanh Lộc","Địa chỉ email: Loc@gmail.com"));
	monCongNghe2.setTenMonHoc(new GiangVien("Môn: ","Java Core - Java Web"));
	monTiengAnh2.setGiangVienChinh(new GiangVien("Trần Thị Hương."," Địa chỉ email: Huong@gmail.com"));
	monTiengAnh2.setTroGiang(new GiangVien("Đỗ Thị Nguyên."," Địa chỉ email: Nguyen@gmail.com"));
	
	monCongNghe3.setGiangVienChinh(new GiangVien("Hồ Tấn Tài.", " Địa chỉ email: Tai@gmail.com"));
	monCongNghe3.setTroGiang(new GiangVien("Nguyễn Tất Hoang.", " Địa chỉ email: Hoang@gmail.com"));
	monCongNghe3.setMentor(new GiangVien("Nguyễn Thanh Phúc","Địa chỉ email: Phuc@gmail.com"));
	monCongNghe3.setTenMonHoc(new GiangVien("Môn: "," Lập trình Anroid"));
	
	monThucTap.setTenMonHoc(new GiangVien("Môn: "," Học kỳ thực tập "));
	monThucTap.setGiangVienPhuTrach(giangVienPhuTrach);
	
	DaoTaoNganHan daoTaoNganHan = context.getBean("daoTaoNganHan",DaoTaoNganHan.class);
	MonCongNghe monCongNghe5 = context.getBean("monCongNghe", MonCongNghe.class);
	MonCongNghe monCongNghe6 = context.getBean("monCongNghe", MonCongNghe.class);
	
	monCongNghe5.setGiangVienChinh(new GiangVien("Nguyễn Thanh Long.", " Địa chỉ email: Long@gmail.com"));
	monCongNghe5.setTroGiang( new GiangVien("Trần Minh Tùng.", " Địa chỉ email: Tung@gmail.com"));
	monCongNghe5.setMentor(new GiangVien("Lê Văn Huấn.", " Địa chỉ email: Hua@gmail.com"));
	monCongNghe5.setTenMonHoc( new GiangVien("Môn: "," Chủ đề Java"));
	
	monCongNghe6.setGiangVienChinh(new GiangVien("Nguyễn Thanh Hóa.", " Địa chỉ email: Hoa@gmail.com"));
	monCongNghe6.setTroGiang( new GiangVien("Trần Minh Phú.", " Địa chỉ email: Phu@gmail.com"));
	monCongNghe6.setMentor(new GiangVien("Lê Văn Hữa.", " Địa chỉ email: Hua@gmail.com"));
	monCongNghe6.setTenMonHoc( new GiangVien("Môn: "," Chủ đề Web Full Stack"));
	
	
	
	HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
	hocKy1.setMonCongNghe(monCongNghe1);
	hocKy1.setMonTiengAnh(monTiengAnh1);
	HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);
	hocKy2.setMonCongNghe(monCongNghe2);
	hocKy2.setMonTiengAnh(monTiengAnh2);
	HocKy3 hocKy3 = context.getBean("hocKy3", HocKy3.class);
	hocKy3.setMonCongNghe(monCongNghe3);
	HocKy4 hocKy4 = context.getBean("hocKy4", HocKy4.class);
	hocKy4.setMonThucTap(monThucTap);
	HocKyJava hocKyJava = context.getBean("hocKyJava", HocKyJava.class);
	hocKyJava.setMonCongNghe(monCongNghe5);
	HocKyWebFullStack hocKyWebFullStack = context.getBean("hocKyWebFullStack", HocKyWebFullStack.class);
	hocKyWebFullStack.setMonCongNghe(monCongNghe6);
	
	List<HocKy> hocKy = new ArrayList<HocKy>();
	hocKy.add(hocKy1);
	hocKy.add(hocKy2);
	hocKy.add(hocKy3);
	hocKy.add(hocKy4);
	
	List<HocKy> hocKyNH = new ArrayList<HocKy>();
	hocKy.add(hocKyJava);
	hocKy.add(hocKyWebFullStack);
	
	
	daoTaoDaiHan.setHocKy(hocKy);
	daoTaoNganHan.setHocKy(hocKyNH);
	
	LopHoc lop1703 = new LopHoc();
	lop1703.setDaoTaoDaiHan(daoTaoDaiHan);
	lop1703.setSinhVien(new SinhVien("Nguyễn Thanh Long", "509 Ngô Quyền", "LongNT@gmail.com", "SDT: 0974394074"));
	lop1703.setSinhVien(new SinhVien("Nguyễn Thanh Lộc", "Quảng Trị", "Loc@gmail.com", "SDT: 0947595949"));
	lop1703.setSinhVien(new SinhVien("Nguyễn Thanh Phước", "GiaLai", "Phuoc@gmail.com", "SDT: 097435522"));
	lop1703.setSinhVien(new SinhVien("Nguyễn Thanh Đức", "Kim Long", "Duc@gmail.com", "SDT: 0974889024"));
	lop1703.setSinhVien(new SinhVien("Nguyễn Thanh Hoài", "Hải Quế", "Hoai@gmail.com", "SDT: 0975626330"));
	
	LopHoc lop1802 = new LopHoc();
	lop1802.setDaoTaoNganHan(daoTaoNganHan);
	lop1802.setSinhVien(new SinhVien("Nguyễn Thanh Long", "509 Ngô Quyền", "LongNT@gmail.com", "SDT: 0974394074"));
	lop1802.setSinhVien(new SinhVien("Nguyễn Thanh Lộc", "Quảng Trị", "Loc@gmail.com", "SDT: 0947595949"));
	lop1802.setSinhVien(new SinhVien("Nguyễn Thanh Phước", "GiaLai", "Phuoc@gmail.com", "SDT: 097435522"));
	lop1802.setSinhVien(new SinhVien("Nguyễn Thanh Đức", "Kim Long", "Duc@gmail.com", "SDT: 0974889024"));
	lop1802.setSinhVien(new SinhVien("Nguyễn Thanh Hoài", "Hải Quế", "Hoai@gmail.com", "SDT: 0975626330"));
  
	 System.out.println(lop1703.mangSachDiHoc());  
	 System.out.println(lop1802.mangSachDiHoc());
	 context.close();
	}
}
