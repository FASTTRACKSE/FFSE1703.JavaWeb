package ffse20.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ffse20.entity.*;

public class MainAppSpring {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		// Náº¡p file config spring tá»« applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// Táº¡o bean tá»« spring containner
		SinhVienSpring sinhVien1 = context.getBean("sinhvien1", SinhVienSpring.class);
		System.out.println("Nhập tên sinh vien :");
		String ten = input.nextLine();
		sinhVien1.setHoTen(ten);		
		

		MonToan monToan = context.getBean("monToan", MonToan.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);
		MonHoa monHoa = context.getBean("monHoa", MonHoa.class);
		
		
		DaoTaoNganHan  heDaoTaoNganHan = context.getBean("daoTaoNganHan", DaoTaoNganHan.class);
//		DaoTaoDaiHan  heDaoTaoDaiHan = context.getBean("daoTaonDaiHan", DaoTaoDaiHan.class);
		
		List<MonHoc> monHoc1 = new ArrayList<MonHoc>();
		monHoc1.add(monToan);
		monHoc1.add(monLy);
		monHoc1.add(monHoa);

		sinhVien1.setMonHoc(monHoc1);
		sinhVien1.setHeDaoTao(heDaoTaoNganHan);
		System.out.println(sinhVien1.mangSachDiHoc());
		context.close();
	}

}
