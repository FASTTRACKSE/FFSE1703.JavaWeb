package fasttrackse.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sinhVien1")
@Scope("prototype")
public class SinhVien {
	private String hoTen;
	private List<MonHoc> monHoc;
	
	@Autowired
	@Qualifier("daoTaoDaiHan")
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

	public SinhVien() {
		super();
	}

	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public SinhVien(String hoTen, HeDaoTao heDaoTao) {
		super();
		this.hoTen = hoTen;
		this.heDaoTao = heDaoTao;
	}

	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + heDaoTao.getGioHoc();
		
		for (MonHoc x : monHoc) {
			result += "\n\t- " + x.mangSachDiHoc() + x.giangVien();
			
		}
		
		return result;
	}

}