package model;

public class SinhVien {
	private String userid,name,ngaysinh,quequan,gioitinh,lop;
	
	public SinhVien(String ID,String name,String date,String que,String gt,String lop) {
		this.userid = ID;
		this.name = name;
		this.ngaysinh = date;
		this.quequan = que;
		this.gioitinh = gt;
		this.lop = lop;
	}
	public SinhVien() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
	public String getId() {
		return userid;
	}
	public void setId(String id) {
		this.userid = id;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	
}
