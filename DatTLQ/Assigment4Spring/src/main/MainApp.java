package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import entity.*;


public class MainApp {
	 
	 public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		 List<SinhVien> listSV= new ArrayList<>();
		 listSV.add(new SinhVien("Quốc Đạt","ronbi2810@gmail.com","Đà Nẵng","01223552898"));
		 
		 MonCongNghe monCN1= context.getBean("monCongNghe",MonCongNghe.class);
		 monCN1.setTenMonHoc("Nhập Môn Lập Trình");
		 monCN1.setTenGV(new GiangVien("Nguyễn Duy Nghiêm", "nghiemnd@gmail.com"));
		 monCN1.setMentor(new GiangVien("Phạm Nguyên Vũ", "vupn@gmail.com"));
		 monCN1.setTroGiang(new GiangVien("Hehe", "hehhe@gmail.com"));
		 
		 MonCongNghe monCN2= context.getBean("monCongNghe",MonCongNghe.class);
		 monCN2.setTenMonHoc("HTML&CSS");
		 monCN2.setTenGV(new GiangVien("Cao Lê Thành", "thanhcl@gmail.com"));
		 monCN2.setMentor(new GiangVien("Nguyễn Nghĩa", "nghian@gmail.com"));
		 monCN2.setTroGiang(new GiangVien("Huhu", "huhhe@gmail.com"));

		 MonCongNghe monCN3= context.getBean("monCongNghe",MonCongNghe.class);
		 monCN3.setTenMonHoc("Lập trình PHP");
		 monCN3.setTenGV(new GiangVien("Nguyễn Duy Nghiêm", "nghiemnd@gmail.com"));
		 monCN3.setMentor(new GiangVien("Phạm Nguyên Vũ", "vupn@gmail.com"));
		 monCN3.setTroGiang(new GiangVien("Hehe", "hehhe@gmail.com"));
		 
		 MonCongNghe monCN4= context.getBean("monCongNghe",MonCongNghe.class);
		 monCN4.setTenMonHoc("Lập trình JAVA");
		 monCN4.setTenGV(new GiangVien("Nguyễn Duy Nghiêm", "nghiemnd@gmail.com"));
		 monCN4.setMentor(new GiangVien("Phạm Nguyên Vũ", "vupn@gmail.com"));
		 monCN4.setTroGiang(new GiangVien("Hehe", "hehhe@gmail.com"));
		 
		 MonCongNghe monCN5= context.getBean("monCongNghe",MonCongNghe.class);
		 monCN5.setTenMonHoc("Web Full Stack");
		 monCN5.setTenGV(new GiangVien("Cao Lê Thành", "thanhcl@gmail.com"));
		 monCN5.setMentor(new GiangVien("Nguyễn Nghĩa", "nghian@gmail.com"));
		 monCN5.setTroGiang(new GiangVien("Huhu", "huhhe@gmail.com"));
		 
		 MonTiengAnh monTA= context.getBean("monTiengAnh",MonTiengAnh.class);
		 monTA.setTenMonHoc("Môn Tiếng Anh");
		 monTA.setLevel("Level 1");
		 monTA.setTenGV(new GiangVien("Lê Thị Mỹ Hồng", "hongltm@gmail.com"));
		 monTA.setTroGiang(new GiangVien("Phạm Diệp Hà", "hadp@gmail.com"));
		 
		 MonThucTap monTT= context.getBean("monThucTap",MonThucTap.class);
		 monTT.setTenCompany("Công ty phần mềm FPT");
		 monTT.setTenGV(new GiangVien("Tống Lê Quốc Đạt", "dattlq@gmail.com"));
		 
		 List<MonCongNghe> listMonHoc= new ArrayList<>();
		 listMonHoc.add(monCN1);
		 listMonHoc.add(monCN2);
		 listMonHoc.add(monCN3);
		 listMonHoc.add(monCN4);
		 listMonHoc.add(monCN5);

		
		 HocKi1 hk1=context.getBean("hocKi1",HocKi1.class);
		 hk1.setListMonCongNghe(listMonHoc);
		 hk1.setMonTiengAnh(monTA);
		 
		 HocKi2 hk2=context.getBean("hocKi2",HocKi2.class);
		 hk2.setListMonCongNghe(listMonHoc);
		 hk2.setMonTiengAnh(monTA);
		 
		 List<HocKi> listHK= new ArrayList<>();
		 listHK.add(hk1);
		 listHK.add(hk2);

		 
		 
		 ClassSV lop=context.getBean("classSV", ClassSV.class);
		 DaoTaoDaiHan daiHan=context.getBean("daoTaoDaiHan", DaoTaoDaiHan.class);
		 DaoTaoNganHan nganHan=context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
		 lop.setLop("FFSE1703");
		 lop.setHeDaoTao(daiHan);
		 lop.setSinhVien(listSV);
		 
	}
	  
	
	 
}
