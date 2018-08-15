package model;

import java.util.List;

public class SinhVienVer2 {
	private String hoTen;
	private List<MonHoc> monHoc;
	private HeDaoTao daoTao;
	
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

	public HeDaoTao getDaoTao() {
		return daoTao;
	}

	public void setDaoTao(HeDaoTao daoTao) {
		this.daoTao = daoTao;
	}

	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + daoTao.getGioHoc();
		
		for (MonHoc x : monHoc) {
			result += "\n\t- " + x.mangSachDiHoc();
		}
		
		return result;
	}
}
