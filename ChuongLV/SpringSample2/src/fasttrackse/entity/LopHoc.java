package fasttrackse.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LopHoc{
	public String lopHoc;
	public List<SinhVien> sinhVien;
	public List<MonHoc> monHoc;
	
	@Autowired
	@Qualifier("daoTaoDaiHan")
	public HeDaoTao daoTao;
	public HocKy hocKy;
	
	public List<SinhVien> getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(List<SinhVien> sinhVien) {
		this.sinhVien = sinhVien;
	}

	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public HocKy getHocKy() {
		return hocKy;
	}

	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}

	public HeDaoTao getDaoTao() {
		return daoTao;
	}

	public void setDaoTao(HeDaoTao daoTao) {
		this.daoTao = daoTao;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public String getLop() {
		String result = lopHoc +" :\n";
		result += daoTao.getGioHoc();
		result += "\n" + "+ " + hocKy.hocKy();
		result += "\n"+"+ Danh sách môn học:";
		for (MonHoc x : monHoc) {
			result +="\n\t- "+x.chonMonHoc();
		}
		result += "\n" + "+ Danh sách sinh viên:";
		for(SinhVien x : sinhVien) {
			result +="\n\t- "+x.getHoTen();
		}
		return result;
	}

}