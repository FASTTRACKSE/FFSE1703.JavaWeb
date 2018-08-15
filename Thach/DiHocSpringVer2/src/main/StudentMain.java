package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.KhoaHocDaiHan;
import bean.KhoaHocNganHan;
import bean.MonHoa;
import bean.MonHoc;
import bean.MonLy;
import bean.MonToan;
import bean.Student;

public class StudentMain {
	public static Scanner myInput = new Scanner(System.in);
	public static Student objMon = new Student();
	public static String ten;

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		myMenu();

	}
	
	public static void myMenu() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Student student  = context.getBean("student", Student.class);
//		Student student2  = context.getBean("student", Student.class);
		MonToan monToan = context.getBean("monToan", MonToan.class);
		MonLy monLy = context.getBean("monLy", MonLy.class);
		MonHoa monHoa =  context.getBean("monHoa", MonHoa.class);
		
		KhoaHocDaiHan  khoaDaiHan = context.getBean("khoaDaiHan", KhoaHocDaiHan.class);
		KhoaHocNganHan  khoaNganHan = context.getBean("khoaNganHan", KhoaHocNganHan.class);
		
		List<MonHoc> monHoc = new ArrayList<MonHoc>();
		monHoc.add(monToan);
		monHoc.add(monLy);
		monHoc.add(monHoa);
		
		List<MonHoc> monHoc2 = new ArrayList<MonHoc>();
		monHoc2.add(monToan);
		monHoc2.add(monLy);
		
		student.setHoTen("Thạch");
		student.setMonHoc(monHoc);
		student.setKhoaHoc(khoaDaiHan);
		student.diHoc();
		
		student.setHoTen("Tuấn");
		student.setMonHoc(monHoc);
		student.setKhoaHoc(khoaNganHan);
		student.diHoc();
		
		context.close();
		}
	}
