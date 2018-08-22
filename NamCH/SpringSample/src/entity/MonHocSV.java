package entity;

public class MonHocSV implements MonHoc {
	private String tenMon,tenGV;
	public MonHocSV( String tenMon, String tenGV) {
		this.tenMon = tenMon;
		this.tenGV = tenGV;
	}
	@Override
	public void getTenGV() {
		// TODO Auto-generated method stub
		System.out.println("Tên Giảng Viên : "+tenGV);
	}

	@Override
	public void mangSachDiHoc() {
		// TODO Auto-generated method stub
		System.out.println("Mang Sách  : "+tenMon);
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	
}
