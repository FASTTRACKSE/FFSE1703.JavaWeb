package Ass1.Main;

import java.util.Scanner;
import Ass1.Monhoc.*;
public class MainApp {
	public static Scanner input = new Scanner(System.in);
	static SinhVien a = new SinhVien();

	public static void main(String[] args) {
		a = new SinhVien();
		System.out.println("Nhập Tên Sinh Vien :");
		String ten = input.nextLine();
		a.setHoTen(ten);
		ChonMon();
	}

	public static void ChonMon() {
		// TODO Auto-generated method stub
		for(;;)
		{
			System.out.println(">>               Chọn Môn Học           <<");
			System.out.println("+----------------------------------------+");
			System.out.println("|1. Toán                                 |");
			System.out.println("|2. Lý                                   |");
			System.out.println("|3. Hóa                                  |");
			System.out.println("|4. Kết Thúc                             |");
			System.out.println("+----------------------------------------+");
			System.out.println(">>            chọn chức năng.         <<");
			int myOption = input.nextInt();
			if (myOption == 1) {
				Toan();
			} else if (myOption == 2) {
				Ly();
			} else if (myOption == 3) {
				Hoa();
			} else if (myOption == 4) {
				ketThuc();
			}
			input.nextLine();
		}
		
	}
 
	public static void Toan() {
		a.setMonHoc(new MonToan());
		System.out.println(a.mangSachDiHoc());
	}

	public static void Ly() {
		a.setMonHoc(new MonLy());
		System.out.println(a.mangSachDiHoc());
	}

	public static void Hoa() {
		a.setMonHoc(new MonHoa());
		System.out.println(a.mangSachDiHoc());
	}

	public static void ketThuc() {
		System.out.println("ket thuc!!!!!");
		System.exit(0);
	}

}
