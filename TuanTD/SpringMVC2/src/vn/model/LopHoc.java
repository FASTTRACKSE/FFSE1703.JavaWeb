package vn.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class LopHoc {
	private String tenLop;
	private List<Student> student;
	@Autowired
	@Qualifier("daoTaoDaiHan")
	private HeDaoTao heDaoTao;
	private HocKy hocKy;
	private List<MonHoc> monHoc;

	public LopHoc() {
		super();
	}

	public LopHoc(String tenLop) {
		super();
		this.tenLop = tenLop;
	}

	public LopHoc(String tenLop, HeDaoTao heDaoTao) {
		super();
		this.tenLop = tenLop;
		this.heDaoTao = heDaoTao;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}

	public String inSinhVien() {
		String result = "Bạn " + tenLop + ": ";
		result += "\n" + heDaoTao.heDaoTao() +"\n"+ hocKy.getTenHocKy();

		for (MonHoc x : monHoc) {
			result += "\n\t- " + x.getTenMonHoc() + "\t" + "(" + x.getGiangVien() + ")" + "\n";
		}
		result += "Danh Sách Sinh VIÊN";
		for (Student x : student) {
			result += "\n\t-" + x.getHoTen();
		}

		return result;
	}
}
