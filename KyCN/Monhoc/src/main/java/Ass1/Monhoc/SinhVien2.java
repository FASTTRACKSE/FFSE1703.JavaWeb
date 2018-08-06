package Ass1.Monhoc;
import Ass1.Main.*;
public class SinhVien2 {
	private String HoTen;
	private MonHoc monHoc;
	private HeDaoTao heDaoTao;

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}


	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public String mangSachDiHoc() {
		return "Bạn " + HoTen +  monHoc.mangSachDiHoc();
	}
	public String heDaoTao() {
		return "Bạn " + HoTen +  heDaoTao.heDaoTao();
	}

}