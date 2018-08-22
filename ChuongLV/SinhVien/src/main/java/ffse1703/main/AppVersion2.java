package ffse1703.main;

import java.util.ArrayList;
import java.util.Scanner;
import ffse1703.SinhVien.*;

public class AppVersion2 {
	
	public static Scanner input = new Scanner(System.in);
	public static ArrayList<SinhVien> arrHinhHoc = new ArrayList<SinhVien>();
	public static SinhVien a = new SinhVien();
	
	public static void main(String[] args) {
		a = new SinhVien();
		System.out.println("Nhập tên sinh viên:");
		String ten = input.nextLine();
		a.setHoTen(ten);
		showMyMenu();
		
	}
		
		public static void showMyMenu() {
			
			 {
				System.out.println(">>    SINH VIÊN ĐI HỌC     <<");
				System.out.println("+----------------------------------------+");
				System.out.println("|1. Hệ đào tạo ngắn hạn                  |");
				System.out.println("|2. Hệ đào tạo dài hạn                   |");
				System.out.println("|3. Chọn môn học                         |");
				System.out.println("|4. Kết thúc                             |");
				System.out.println("+----------------------------------------+");
				System.out.println(">>            Lựa chọn của bạn?         <<");
				int myOption = input.nextInt();
				if (myOption == 1) {
					daiHan();
				} else if (myOption == 2) {
					nganHan();
				} else if (myOption == 3) {
					chonMon();
				} else if (myOption == 4) {
					ketThuc();
				}
				input.nextInt();
					}
				
			 }

		private static void ketThuc() {
			// TODO Auto-generated method stub
			
		}

		private static void chonMon() {
			// TODO Auto-generated method stub
			
		}

		private static void nganHan() {
			// TODO Auto-generated method stub
			
		}

		private static void daiHan() {
			// TODO Auto-generated method stub
			
		}
	 
}
