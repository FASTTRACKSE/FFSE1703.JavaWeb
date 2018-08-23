package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import fasttrackse.entity.DaoTaoDaiHan;
import fasttrackse.entity.HeDaoTao;
import fasttrackse.entity.HocKy1;
import fasttrackse.entity.HocKy2;
import fasttrackse.entity.LopHoc;
import fasttrackse.entity.MonHoc;
import fasttrackse.entity.MonJavaCore;
import fasttrackse.entity.MonJavaWeb;
import fasttrackse.entity.MonNMLT;
import fasttrackse.entity.SinhVien;
import fasttrackse.entity.WebFrontEnd;

public class AnnotationMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LopHoc Lop1703 =  context.getBean("lopHoc", LopHoc.class);
		
		LopHoc Lop1802 =  context.getBean("lopHoc", LopHoc.class);
		
		MonJavaCore monJavaCore = context.getBean("monJavaCore", MonJavaCore.class);
		MonJavaWeb monJavaWeb = context.getBean("monJavaWeb", MonJavaWeb.class);
		MonNMLT monNMLT = context.getBean("monNMLT", MonNMLT.class);
		WebFrontEnd webFrontEnd = context.getBean("webFrontEnd", WebFrontEnd.class);
		
		HeDaoTao daoTaoNganHan = context.getBean("daoTaoNganHan", HeDaoTao.class);
		HeDaoTao daoTaoDaiHan = context.getBean("daoTaoDaiHan", HeDaoTao.class);
		
		HocKy1 hocKy1 = context.getBean("hocKy1",HocKy1.class);
		HocKy2 hocKy2 = context.getBean("hocKy2",HocKy2.class);
		
	    List<SinhVien> sV = new ArrayList<SinhVien>();
	    sV.add(new SinhVien("Nguyễn Thanh Long"));
	    sV.add(new SinhVien("Nguyễn Thanh Lộc"));
	    sV.add(new SinhVien("Nguyễn Thanh Thủy"));
	    
	    List<SinhVien> sV2 = new ArrayList<SinhVien>();
	    sV2.add(new SinhVien("Nguyễn Thanh Hoài"));
	    sV2.add(new SinhVien("Nguyễn Thị Kiều Mi"));
	    sV2.add(new SinhVien("Nguyễn Thị Hằng"));

        List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
        monHoc1.add(monJavaCore);
        monHoc1.add(monJavaWeb);
     
        List<MonHoc> monHoc2 = new ArrayList<MonHoc>();   
        monHoc2.add(monNMLT);
        monHoc2.add(webFrontEnd);
        
        Lop1703.setSinhVien(sV);
        Lop1703.setLopHoc("Lớp1703");
        Lop1703.setHeDaoTao(daoTaoDaiHan);
        Lop1703.setHocKy(hocKy1);
        Lop1703.setMonHoc(monHoc1);
        
        Lop1802.setSinhVien(sV2);
        Lop1802.setLopHoc("Lớp1802");
        Lop1802.setHeDaoTao(daoTaoNganHan);
        Lop1802.setHocKy(hocKy2);
        Lop1802.setMonHoc(monHoc2);
        
       System.out.println(Lop1703.mangSachDiHoc());
       System.out.println(Lop1802.mangSachDiHoc());
       
       context.close();
}
}
