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
@Component("lop")

public class SinhVienNangCao {

	private List<MonHoc> monHoc;
	@Autowired
	@Qualifier("daoTaoDaiHan")
	private HeDaoTao heDaoTao;
	private HocKy hocKy;
	private Lop lop;
	private List<ListSinhVien> hoTen;

	public List<ListSinhVien> getHoTen() {
		return hoTen;
	}

	public void setHoTen(List<ListSinhVien> hoTen) {
		this.hoTen = hoTen;
	}

	public HocKy getHocKy() {
		return hocKy;
	}

	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
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

	public String Lop() {
		/*
		 * String result = "Bạn " + hoTen + ": "; result += "\n" + heDaoTao.getGioHoc();
		 * 
		 * for (MonHoc x : monHoc) { result += "\n\t- " + x.mangSachDiHoc()+" "+
		 * x.giaoVien(); }
		 * 
		 * return result;
		 */
		String result = "Danh sách sinh viên ";
		result += lop.getThongTinLop();
		result += "\n" + heDaoTao.getGioHoc();

		result += "\n- " + "HỌC KỲ:" + hocKy.getHocKy();
		for (MonHoc x : monHoc) {

			result += "\n\t- " + x.mangSachDiHoc() + " " + x.giaoVien();
		}
		result += "\n- " + "DANH SÁCH SINH VIÊN:" ;

		for(ListSinhVien x : hoTen) {
			result +="\n\t- "+x.getHoTen();
		}
		return result;

	}



}
