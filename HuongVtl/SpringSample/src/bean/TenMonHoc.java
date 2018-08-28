package bean;

public class TenMonHoc implements MonHoc{
	private String tenGiangVien;
	private String tenMonHoc;
	public TenMonHoc(String tenMonHoc,String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
		this.tenMonHoc = tenMonHoc;
	}
	public String mangSachDiHoc() {
		
		return "mang sách "+tenMonHoc+" "+ "đi học";
	}

	public String giangVien() {
		
		return "giáo viên"+" "+tenGiangVien;
	}

}
