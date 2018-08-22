package entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class SinhVien {
	private String tenSv;
	private MonHoc monHoc;
	

	@Autowired
	@Qualifier("daoTaoNganHan")
	private HeDaoTao heDaoTao;
	private HocKy hocKy;
	private Lop lop;
	
	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public SinhVien() {

	}

	public SinhVien(String tenSv) {
		this.tenSv = tenSv;
	}

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	
	public HocKy getHocKy() {
		return hocKy;
	}

	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}

//	public String mangSachDiHoc() {
//		String a = "";
//		for (MonHoc x : monHoc) {
//			a = a + x.mangSachDiHoc()+" " + x.getTenGV() +"\n";
//		}
//		return a;
//
//	}

//	public String diHoc() {
//		return "Sinh Viên Tên : " + tenSv + "\n" + heDaoTao.hedaoTao() + "\n" +mangSachDiHoc();
//	}
//	public String danhSachSV() {
//		return "Sinh Viên Tên : " + tenSv + "\n" + heDaoTao.hedaoTao() + "\n" +mangSachDiHoc() +"\n"
//				+"Học "+lop.getTenLop()+"\n" ;
//	}
	public void inThongTin() {
		System.out.println(tenSv);
		lop.getTenLop();
		hocKy.getTenHocKy();
		monHoc.getTenGV();
		monHoc.mangSachDiHoc();
	}
}
