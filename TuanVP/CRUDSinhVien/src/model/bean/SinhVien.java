package model.bean;

public class SinhVien {
	protected int id;
	protected String hodem, ten, ngaysinh, gioitinh, quequan, lop, xeploai;
	protected float diemlp1, diemlp2, diemtb;
	public SinhVien() {
		
	}
	public SinhVien(int id) {
		this.id = id;
	}
	public SinhVien(String hodem, String ten, String ngaysinh, String gioitinh, String quequan, String lop, float diemlp1, float diemlp2) {
		this.hodem = hodem;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.quequan = quequan;
		this.lop = lop;
		this.diemlp1 = diemlp1;
		this.diemlp2 = diemlp2;
		tinhDiemTB();
		xepLoai();
	}
	public SinhVien(int id, String hodem, String ten, String ngaysinh, String gioitinh, String quequan, String lop, float diemlp1, float diemlp2) {
		this.id = id;
		this.hodem = hodem;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.quequan = quequan;
		this.lop = lop;
		this.diemlp1 = diemlp1;
		this.diemlp2 = diemlp2;
		tinhDiemTB();
		xepLoai();
	}
	public SinhVien(int id, String hodem, String ten, String ngaysinh, String gioitinh, String quequan, String lop, float diemlp1, float diemlp2, float diemtb, String xeploai) {
		this.id = id;
		this.hodem = hodem;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.quequan = quequan;
		this.lop = lop;
		this.diemlp1 = diemlp1;
		this.diemlp2 = diemlp2;
		this.diemtb = diemtb;
		this.xeploai = xeploai;
	}
	public String getHodem() {
		return hodem;
	}
	public void setHodem(String hodem) {
		this.hodem = hodem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getXeploai() {
		return xeploai;
	}
	public void setXeploai(String xeploai) {
		this.xeploai = xeploai;
	}
	public float getDiemlp1() {
		return diemlp1;
	}
	public void setDiemlp1(float diemlp1) {
		this.diemlp1 = diemlp1;
	}
	public float getDiemlp2() {
		return diemlp2;
	}
	public void setDiemlp2(float diemlp2) {
		this.diemlp2 = diemlp2;
	}
	public float getDiemtb() {
		return diemtb;
	}
	public void setDiemtb(float diemtb) {
		this.diemtb = diemtb;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float tinhDiemTB() {
		return (float) ((getDiemlp1() + getDiemlp2())/2.0);
	}
	public String xepLoai() {
		String xeploai = "";
		if (tinhDiemTB()<= 4.9) {
			xeploai = "Kém";
		} else if (tinhDiemTB() >=5 && tinhDiemTB() <=6.4) {
			xeploai = "Trung bình";
		} else if (tinhDiemTB() >=6.5 && tinhDiemTB() <=7.9) {
			xeploai = "Khá";
		} else {
			xeploai = "Giỏi";
		}
		return xeploai;
	}
}
