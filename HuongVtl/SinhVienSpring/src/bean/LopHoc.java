package bean;

public class LopHoc {
	private String tenLop;
	private SinhVien sinhVien;
	private HeDaoTao heDaoTao;
	private HocKy hocKy;
	private MonHoc monHoc;
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public SinhVien getTenSv() {
		return sinhVien;
	}
	public void setTenSv(SinhVien tenSv) {
		this.sinhVien = tenSv;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public HocKy getHocKy() {
		return hocKy;
	}
	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	public void inThongTin() {
		System.out.println("Lớp"+" "+tenLop);
		System.out.println("Học"+" "+heDaoTao.heDaoTao());
		System.out.println(sinhVien.getTenSv());
		System.out.println(monHoc.monHoc()+ monHoc.GiangVien());
		
	}
}
