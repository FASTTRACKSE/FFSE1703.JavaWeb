package bean;

import java.util.Scanner;

public class SinhVien {
	private String hoTen;
	public static Scanner myInput = new Scanner(System.in);
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void mangSachToanDiHoc() {

		System.out.println(hoTen +" "+"Hay Mang Sach Toan Di Hoc !!");
	}
	public void mangSachLyDiHoc() {

		System.out.println(hoTen +" "+"Hay Mang Sach Ly Di Hoc !!");
	}
	public void mangSachHoaDiHoc() {
		
		System.out.println(hoTen +" "+"Hay Mang Sach Hoa Di Hoc !!");
	}
}
