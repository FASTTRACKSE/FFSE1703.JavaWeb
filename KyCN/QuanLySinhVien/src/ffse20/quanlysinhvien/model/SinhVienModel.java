package ffse20.quanlysinhvien.model;

public class SinhVienModel {
	private String hoDem,ten,queQuan,gioiTinh,lop,ngaySinh;
	private int  id;
//	public SinhVienModel(int id,String hoDem, String ten,int ngaySinh, String queQuan, String gioiTinh, String lop) {
//		super();
//		this.hoDem = hoDem;
//		this.ten = ten;
//		this.queQuan = queQuan;
//		this.gioiTinh = gioiTinh;
//		this.lop = lop;
//		this.ngaySinh = ngaySinh;
//	}
	public SinhVienModel() {
		
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String string) {
		this.ngaySinh = string;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
