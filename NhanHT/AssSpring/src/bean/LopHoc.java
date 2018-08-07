package bean;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class LopHoc {
	private String tenLop;
	private HocKy hocKy;
	private HeDaoTao heDaoTao;
	private ArrayList<MonHoc> monHoc = new ArrayList<>();
	private ArrayList<SinhVien> sinhVien = new ArrayList<>();

	public LopHoc() {
		super();
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public HocKy getHocKy() {
		return hocKy;
	}

	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public ArrayList<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(ArrayList<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public ArrayList<SinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(ArrayList<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}

	public LopHoc(String tenLop, HocKy hocKy, HeDaoTao heDaoTao, ArrayList<MonHoc> monHoc,
			ArrayList<SinhVien> sinhVien) {
		super();
		this.tenLop = tenLop;
		this.hocKy = hocKy;
		this.heDaoTao = heDaoTao;
		this.monHoc = monHoc;
		this.sinhVien = sinhVien;
	}



	public void in() {
		System.out.println(tenLop);
		System.out.println(heDaoTao.heDaoTao());
		hocKy.hocKy();
		for (SinhVien x : sinhVien) {
			System.out.println(x.getTenSv());
		}

//		for(int i=0;i<monHoc.size();i++) {
//			System.out.println("Môn Học: "+monHoc.get(i).monHoc());
//		}
		System.out.println("-------------------------");
	}
}
