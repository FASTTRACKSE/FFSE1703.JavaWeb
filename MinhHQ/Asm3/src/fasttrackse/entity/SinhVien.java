package fasttrackse.entity;

import java.util.List;

public class SinhVien {
	private String hoTen;
	private List<MonHoc> monHoc;
	private HeDaoTao heDaoTao;
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String name) {
		hoTen = name;
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
	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + heDaoTao.getGioHoc();
		
		for (MonHoc x : monHoc) {
			result += "\n\t- " + x.mangSachDiHoc();
		}
		
		return result;
	}
}
