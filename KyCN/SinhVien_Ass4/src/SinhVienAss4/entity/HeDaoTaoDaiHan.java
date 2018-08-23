package SinhVienAss4.entity;
import java.util.List;


public class HeDaoTaoDaiHan implements HeDaoTao {
	public List<HocKy> hocKy;
	
	public HeDaoTaoDaiHan(List<HocKy> hocKy) {
		super();
		this.hocKy = hocKy;
	}

	@Override
	public String heDaoTao() {
	String tt = "\n" + thoiGianDaoTao() +"\n\n";
	for (HocKy hk : hocKy) {
		tt += hk.hocKy() + "\n";
	}
		return tt;
	}

	@Override
	public String thoiGianDaoTao() {

		return "Hệ đào tạo dài hạn : th�?i gian h�?c 16 tháng, sáng 8h30, chi�?u 13h30";
	}

}
