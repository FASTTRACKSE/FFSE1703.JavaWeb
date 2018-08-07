package entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class LopHoc {
	private String tenLop;
	private List<SinhVien> listSinhVien;
	private HeDaoTao heDaoTao;
	
	public LopHoc() {
	
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}
	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public void getLopHoc() {
			System.out.println(tenLop);
			System.out.println(heDaoTao.hocKi());
			System.out.println("+ Danh sách sinh viên:");
			for(SinhVien x:listSinhVien) {
				System.out.println("    - "+x.getSinhVien());
			}
	}
}
