package emtity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*
 * @Scope("prototype") nhiều sv
 */ /* @Autowired tên đói tượng tự động gán */
/* @Qualifier không cần set get */

@Scope("prototype")
@Component("sinhVien1")
public class SinhVienNangCao {

	private String hoTen;	

	private List<MonHoc> monHoc;
	@Autowired
	@Qualifier("daoTaoDaiHan")
	private HeDaoTao heDaoTao;
	private HocKy hocKy;


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
			result += "\n\t- " + x.mangSachDiHoc()+" "+ x.giaoVien();
		}

		return result;
	}
}
