package annotation.entity;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sv1")
@Scope("prototype")
public class SinhVien {
	private String hoTen;
	private ArrayList<MonHoc> mh;
	@Autowired
	@Qualifier("daoTaoDaiHan")
	private HeDaoTao hdt;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public ArrayList<MonHoc> getMh() {
		return mh;
	}

	public void setMh(ArrayList<MonHoc> mh) {
		this.mh = mh;
	}

	public HeDaoTao getHdt() {
		return hdt;
	}

	public SinhVien(String hoTen, HeDaoTao hdt) {
		super();
		this.hoTen = hoTen;
		this.hdt = hdt;
	}

	public SinhVien(String hoTen) {
		super();
		this.hoTen = hoTen;
	}

	public SinhVien() {
	}

	public void setHdt(HeDaoTao hdt) {
		this.hdt = hdt;
	}

	public String mangSach() {
		String result = " Ban " + hoTen + "; ";
		result += "\n" + hdt.getGioHoc();
		for (MonHoc x : mh) {
			result += "\n\t-" + x.mangSach() + x.giangVien();
		}
		return result;
	}
}
