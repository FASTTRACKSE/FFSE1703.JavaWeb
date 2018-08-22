package fasttrackse.main;

import fasttrackse.entity.*;

public class MainApp {

	public static void main(String[] args) {
		SinhVienVersion4 sinhVien = new SinhVienVersion4("Thành");

		// NHẮC BẠN MANG SÁCH TOÁN ĐI HỌC
		// Inject môn Toán cho đối tượng sinhVien qua phương thức setter setMonHoc
		sinhVien.setMonHoc(new MonToan());
		System.out.println(sinhVien.mangSachDiHoc());

		// NHẮC BẠN MANG SÁCH LÝ ĐI HỌC
		// Inject môn Lý cho đối tượng sinhVien qua phương thức setter setMonHoc
		sinhVien.setMonHoc(new MonLy());
		System.out.println(sinhVien.mangSachDiHoc());

		// NHẮC BẠN MANG SÁCH HÓA ĐI HỌC
		// Inject môn Hoá cho đối tượng sinhVien qua phương thức setter setMonHoc
		sinhVien.setMonHoc(new MonHoa());
		System.out.println(sinhVien.mangSachDiHoc());

		// NHẮC BẠN MANG SÁCH ENGLISH ĐI HỌC
		// Inject thêm một môn mới, English bằng cách tạo 1 lớp MonEnglish và inject cho đối tượng sinhVien
		sinhVien.setMonHoc(new MonEnglish());
		System.out.println(sinhVien.mangSachDiHoc());

		// // NHẮC BẠN MANG SÁCH TOÁN ĐI HỌC
		// System.out.println(sinhVien.mangSachToanDiHoc());
		
		// // NHẮC BẠN MANG SÁCH LÝ ĐI HỌC
		// System.out.println(sinhVien.mangSachLyDiHoc());

		// // NHẮC BẠN MANG SÁCH ENGLISH ĐI HỌC
		// System.out.println(sinhVien.mangSachTiengAnhDiHoc());
	}

}
