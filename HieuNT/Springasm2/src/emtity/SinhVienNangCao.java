package emtity;

import java.util.List;

public class SinhVienNangCao {
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

	private String hoTen;
	private List<MonHoc> monHoc;
	private HeDaoTao heDaoTao;
	/*
	 * @Scope("prototype") nhiều sv
	 */ /* @Autowired tên đói tượng tự động gán */
	/* @Qualifier không cần set get */

	public SinhVienNangCao() {
		super();
	}

	public SinhVienNangCao(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + heDaoTao.getGioHoc();

		for (MonHoc x : monHoc) {
			result += "\n\t- " + x.mangSachDiHoc();
		}

		return result;
	}
}
