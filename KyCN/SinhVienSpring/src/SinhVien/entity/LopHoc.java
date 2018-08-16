package SinhVien.entity;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class LopHoc {
	public String lopHoc;
	public List<SinhVienSpring> sinhVien;
	public List<MonHoc> monHoc;
	public HeDaoTao daoTao;
	public HocKy hocKy;

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public List<SinhVienSpring> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(List<SinhVienSpring> sinhVien) {
		this.sinhVien = sinhVien;
	}

	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public HeDaoTao getDaoTao() {
		return daoTao;
	}

	public void setDaoTao(HeDaoTao daoTao) {
		this.daoTao = daoTao;
	}

	public HocKy getHocKy() {
		return hocKy;
	}

	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
	
	public String getLop() {
		String result = lopHoc +" :\n";
		result += daoTao.heDaoTao();
		result += "\n" + "+ " + hocKy.hocKy();
		result += "\n"+"+ Danh sách môn học:";
		for (MonHoc x : monHoc) {
			result +="\n\t- "+x.mangSachDiHoc()+ x.tenGiangVien();
		}
		result += "\n" + "+ Danh sách sinh viên:";
		for(SinhVienSpring x : sinhVien) {
			result +="\n\t- "+x.getHoTen();
		}
		return result;
	}
}
