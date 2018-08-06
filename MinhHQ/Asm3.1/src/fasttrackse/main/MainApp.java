package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import fasttrackse.entity.*;

public class MainApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		SinhVien sinhVien1 = context.getBean("sinhVien", SinhVien.class);
		SinhVien sinhVien2 = context.getBean("sinhVien", SinhVien.class);
		
		MonToan monToan =context.getBean("monToan",MonToan.class);
		MonLy monLy =context.getBean("monLy",MonLy.class);
		MonHoa monHoa =context.getBean("monHoa",MonHoa.class);
		MonEnglish monEnglish =context.getBean("monEnglish",MonEnglish.class);
		MonFrench monFrench =context.getBean("monFrench",MonFrench.class);
		
		DaoTaoNganHan daoTaoNganHan = context.getBean("daoTaoNganHan",DaoTaoNganHan.class);
		
		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
			monHoc1.add(monToan);
			monHoc1.add(monLy);
			monHoc1.add(monHoa);
			
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
			monHoc2.add(monEnglish);
			monHoc2.add(monFrench);
		
		sinhVien1.setHoTen("Minh");
		sinhVien1.setMonHoc(monHoc1);
		sinhVien2.setHoTen("Hiếu");
		sinhVien2.setHeDaoTao(daoTaoNganHan);
		sinhVien2.setMonHoc(monHoc2);
		
		System.out.println(sinhVien1.mangSachDiHoc());
		System.out.println(sinhVien2.mangSachDiHoc());

		context.close();

	}
}