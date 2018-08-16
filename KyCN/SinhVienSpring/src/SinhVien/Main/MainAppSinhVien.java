package SinhVien.Main;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	import org.springframework.context.support.ClassPathXmlApplicationContext;

	import SinhVien.entity.*;

	public class MainAppSinhVien {
		public static Scanner input = new Scanner(System.in);
		public static void main(String[] args) {
			// Náº¡p file config spring tá»« applicationContext.xml
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			
			
			LopHoc lopHoc1 = context.getBean("lopHoc",LopHoc.class);
			LopHoc lopHoc2 = context.getBean("lopHoc",LopHoc.class);
			
			DaoTaoNganHan heDaoTao2 = context.getBean("daoTaoNganHan",DaoTaoNganHan.class);
			DaoTaoDaiHan heDaoTao1 = context.getBean("daoTaoDaiHan",DaoTaoDaiHan.class);
		
			

			MonJavaCore monJavaCore = context.getBean("monJavaCore", MonJavaCore.class);
			MonJavaWeb monJavaWeb = context.getBean("monJavaWeb", MonJavaWeb.class);
			MonNhapMon monNhapMon = context.getBean("monNhapMon", MonNhapMon.class);
			
			HocKy1 hocKy1 = context.getBean("hocKy1", HocKy1.class);
			HocKy2 hocKy2 = context.getBean("hocKy2", HocKy2.class);
			
			
			List<SinhVienSpring> sv1 = new ArrayList<SinhVienSpring>();
			sv1.add(new SinhVienSpring("Hồ Quang Minh"));
			sv1.add(new SinhVienSpring("Hồ Viết Tú"));
			sv1.add(new SinhVienSpring("Lê Thanh Danh"));
			sv1.add(new SinhVienSpring("Lê Phước Hiếu"));
			
			List<SinhVienSpring> sv2 = new ArrayList<SinhVienSpring>();
			sv2.add(new SinhVienSpring("Hồ Quang"));
			sv2.add(new SinhVienSpring("Hồ Viết"));
			sv2.add(new SinhVienSpring("Lê Thanh"));
			sv2.add(new SinhVienSpring("Lê Phước"));

			
			List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
			monHoc1.add(monJavaCore);
			monHoc1.add(monJavaWeb);
			
			List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
			monHoc2.add(monNhapMon);
			



			lopHoc1.setLopHoc("Lớp FFSE1701");
			lopHoc1.setSinhVien(sv1);
			lopHoc1.setMonHoc(monHoc1);
			lopHoc1.setDaoTao(heDaoTao1);
			lopHoc1.setHocKy(hocKy2);
			
			
			
			lopHoc2.setLopHoc("Lớp FFSE1702");
			lopHoc2.setSinhVien(sv2);
			lopHoc2.setMonHoc(monHoc2);
			lopHoc2.setDaoTao(heDaoTao2);
			lopHoc2.setHocKy(hocKy1);
			
			
			
			System.out.println(lopHoc1.getLop());
			System.out.println(lopHoc2.getLop());
			
			context.close();
		}
}
