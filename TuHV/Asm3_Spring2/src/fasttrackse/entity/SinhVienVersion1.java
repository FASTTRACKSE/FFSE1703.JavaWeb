package fasttrackse.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sinhvien")

@Scope("prototype")
public class SinhVienVersion1 {
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

	public SinhVienVersion1() {
		super();
	}

	public SinhVienVersion1(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public SinhVienVersion1(HeDaoTao heDaoTao) {
		super();
		this.heDaoTao = heDaoTao;
	}

	public String mangSachDiHoc() {
		String kqua = "Bạn " + hoTen + ":";
		kqua += "\n" + heDaoTao.getGioHoc();

		for (MonHoc x : monHoc) {
			kqua += "\n\t- " + x.mangSachDiHoc();

		}
		return kqua;
	}

}
