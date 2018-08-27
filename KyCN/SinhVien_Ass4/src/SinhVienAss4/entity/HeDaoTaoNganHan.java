package SinhVienAss4.entity;

import java.util.List;


public class HeDaoTaoNganHan implements HeDaoTao {
	public List<HocKy> hocKy;
	
	public HeDaoTaoNganHan(List<HocKy> hocKy) {
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
		// TODO Auto-generated method stub
		return "Hệ đào tạo ngắn hạn: Th�?i gian h�?c 6 tháng, từ 18h30 – 21h30";
	}

}
