package main;

import java.util.Scanner;

import model.MonHoa;
import model.MonLy;
import model.MonToan;
import model.SinhVien;

public class Main {
	static SinhVien sv = new SinhVien();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Nhap ten :");
		sv.hoten = sc.nextLine();
		menu();
	}
	public static void menu() {
		while(true) {
			System.out.println("Chon He :");
			System.out.println("Mon Toan");
			System.out.println("Mon Ly");
			System.out.println("Mon Hoa");
			int myChoice = sc.nextInt();
			if(myChoice==1) {
			}
			if(myChoice==2) {
				Toan();
			}
			if(myChoice==3) {
				Ly();
			}
			if(myChoice==4) {
				Hoa();
			}
		}
	}
	public static void Toan(){
		sv.setMh(new MonToan());
		System.out.println(sv.mangSach());
	}
	public static void Ly() {
		sv.setMh(new MonLy());
		System.out.println(sv.mangSach());
	}
	public static void Hoa() {
		sv.setMh(new MonHoa());
		System.out.println(sv.mangSach());
	}
}
