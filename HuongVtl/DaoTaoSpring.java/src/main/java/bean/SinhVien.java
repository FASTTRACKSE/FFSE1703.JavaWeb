package bean;

public class SinhVien {
	private String hoTen;
	private MonHoc monHoc;
	private HeDaoTao heDaoTao;
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String mangSachDiHoc() {
		return "Bạn "+hoTen + " nho mang sach " + monHoc.mangSachDiHoc();
	}
	public String heDaoTao() {
		return "Bạn học hệ "+heDaoTao.heDaoTao();
	}
}
