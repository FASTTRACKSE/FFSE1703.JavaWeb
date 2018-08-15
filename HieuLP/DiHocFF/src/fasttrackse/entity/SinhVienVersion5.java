package fasttrackse.entity;

import java.util.List;

public class SinhVienVersion5 {
	private String hoTen;
	private List<MonHoc> monHoc;
	private HeDaoTao heDaoTao;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public SinhVienVersion5() {
		super();
	}

	public SinhVienVersion5(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public SinhVienVersion5(String hoTen, HeDaoTao heDaoTao) {
		super();
		this.hoTen = hoTen;
		this.heDaoTao = heDaoTao;
	}

	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + heDaoTao.khoaDaoTao();
		
		for (MonHoc x : monHoc) {
			result += "\n\t- " + x.mangSachDiHoc();
		}
		
		return result;
	}

}