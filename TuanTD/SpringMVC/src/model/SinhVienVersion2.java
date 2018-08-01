package model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhVienVersion2 {
	private String hoTen;
	List<MonHoc> monHoc;
	@Autowired
	@Qualifier("daoTaoDaiHan")
	private HeDaoTao heDaoTao;

	public SinhVienVersion2() {
		//
	}

	public SinhVienVersion2(String hoTen) {
		// TODO Auto-generated constructor stub
		this.hoTen = hoTen;
	}

	public SinhVienVersion2(String hoTen, HeDaoTao heDaoTao) {
		super();
		this.hoTen = hoTen;
		this.heDaoTao = heDaoTao;
	}

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

	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + heDaoTao.heDaoTao();

		for (MonHoc x : monHoc) {
			result += "\n\t- " + x.mangSachDiHoc() + "\t" +"("+ x.giangVien()+")";
		}

		return result;
	}

}
