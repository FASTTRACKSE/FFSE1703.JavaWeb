package main;

import java.util.ArrayList;
import java.util.Scanner;

import entity.DaoTaoDaiHan;
import entity.DaoTaoNganHan;
import entity.MonHoa;
import entity.MonHoc;
import entity.MonLy;
import entity.MonToan;
import entity.SVVersion3;

public class MainApp2 {
private static String name;
private static Scanner scanner = new Scanner(System.in);
static SVVersion3 sv= new SVVersion3();
static ArrayList<MonHoc> arrMonHoc= new ArrayList<>();
public static void main(String[] args) {
	// TODO Auto-generated method stub
	nhapName();

}
public static void nhapName() {
	while(true) {
		System.out.println("Nhập tên của bạn:");
		name= scanner.nextLine();
		sv.setHoTen(name);
		chonHe();
		scanner.nextLine();
		scanner.nextLine();
		
	}
}

public static void chonHe() {
	while (true) {
		System.out.println("---Chọn Khóa Học---");
		System.out.println("_______________________________________" + "\n");
		System.out.println("1: Khóa Ngắn Hạn ");
		System.out.println("2: Khóa Dài Hạn");
	
		
		System.out.println("_______________________________________" + "\n");

		int input = scanner.nextInt();
		if (input == 1) {
			sv.setHeDaoTao(new DaoTaoNganHan());
			myMenu();
		} else if (input == 2) {
			sv.setHeDaoTao(new DaoTaoDaiHan());
			myMenu();
		}
	}
}
public static void myMenu() {
	while (true) {
		System.out.println("---Chọn Môn Học---");
		System.out.println("_______________________________________" + "\n");
		System.out.println("1: Toán ");
		System.out.println("2: Lý");
		System.out.println("3: Hóa");
		System.out.println("4: IN");
		System.out.println("_______________________________________" + "\n");

		int input = scanner.nextInt();
		if (input == 1) {
			arrMonHoc.add(new MonToan());
			myMenu();
		} else if (input == 2) {
			arrMonHoc.add(new MonLy());
			myMenu();
		} else if (input == 3) {
			arrMonHoc.add(new MonHoa());
			myMenu();
		} else if (input == 4) {
			sv.setListMonHoc(arrMonHoc);
			sv.mangSachDiHoc();
		} 
	}
}
}
