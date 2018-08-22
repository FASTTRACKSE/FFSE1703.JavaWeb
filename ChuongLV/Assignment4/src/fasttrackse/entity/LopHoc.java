package fasttrackse.entity;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class LopHoc {
	
	private String tenLopHoc;
	private List<SinhVien>listSinhVien;
	private HeDaoTao heDaoTao;
	
	public LopHoc() {
	super();	
	}

	public String getTenLopHoc() {
		return tenLopHoc;
	}

	public void setTenLopHoc(String tenLopHoc) {
		this.tenLopHoc = tenLopHoc;
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
	
	public String getLop() {
		String result = "Lớp học:" + tenLopHoc + "\n";
		result += heDaoTao.hocKi();
		result+=" Danh sách sinh viên: \n";
		for (SinhVien sV : listSinhVien) {
			result += sV.getSinhVien()+"\n";
		}
		result+= "\n ================================================== \n";
		return result;
	}

}
