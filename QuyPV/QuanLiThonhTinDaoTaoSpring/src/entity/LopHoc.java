package entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class LopHoc {
	private List<SinhVien> sinhVienList;
	private HeDaoTao hedaotao;
	private String tenLop;
	
	public LopHoc() {
		
	}

	public LopHoc(List<SinhVien> sinhVienList, HeDaoTao hedaotao, String tenLop) {
		this.sinhVienList = sinhVienList;
		this.hedaotao = hedaotao;
		this.tenLop = tenLop;
	}

	public List<SinhVien> getSinhVienList() {
		return sinhVienList;
	}

	public void setSinhVienList(List<SinhVien> sinhVienList) {
		this.sinhVienList = sinhVienList;
	}

	public HeDaoTao getHedaotao() {
		return hedaotao;
	}

	public void setHedaotao(HeDaoTao hedaotao) {
		this.hedaotao = hedaotao;
	}
	
	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	
	public void inDanhSach() {
		System.out.println("**Lớp " + tenLop);
		System.out.print(hedaotao.heDaoTao());
		System.out.println("Danh sách Sinh Viên: ");
		for (SinhVien y : sinhVienList) {
			System.out.println( y.danhSachSinhVien());	
		}
		System.out.println("\n");
	}
	
}
