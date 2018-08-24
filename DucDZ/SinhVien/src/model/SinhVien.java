package model;

public class SinhVien {
	public String hoten;
	public MonHoc mh;
	public HeDaoTao hdt;
	public SinhVien() {

	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public MonHoc getMh() {
		return mh;
	}

	public void setMh(MonHoc mh) {
		this.mh = mh;
	}

	public SinhVien(String hoten, MonHoc mh,HeDaoTao hdt) {
		super();
		this.hoten = hoten;
		this.mh = mh;
		this.hdt=hdt;
	}

	public SinhVien(String hoten) {
		super();
		this.hoten = hoten;
	}
	public String daoTao() {
		return "Ban "+hoten+""+ hdt.daoTao();
	}
	public HeDaoTao getHdt() {
		return hdt;
	}

	public void setHdt(HeDaoTao hdt) {
		this.hdt = hdt;
	}

	public String mangSach() {
		return "Ban " + hoten + "" + mh.mangSach();
	}
}
