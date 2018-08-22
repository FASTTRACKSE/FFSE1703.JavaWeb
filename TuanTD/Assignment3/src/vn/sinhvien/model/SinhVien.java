package vn.sinhvien.model;

public class SinhVien {
     private String hoTen;
     public SinhVien() {
    	 //
     }
     
	public SinhVien(String hoTen) {
 		this.hoTen = hoTen;
 	}
     public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String mangSachToanDiHoc(){
		return "bạn" +hoTen + "Mang sách Toán Đi Học";
//         System.out.println(hoTen + "Mang sách Toán Đi Học");
}
     public void mangSachLyDiHoc(){
         System.out.println(hoTen + "Mang sách Lý Đi Học");
}
     public void mangSachHoaDiHoc(){
         System.out.println(hoTen + "Mang sách Hóa Đi Học");
}
}
