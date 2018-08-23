package bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class SinhVien2 {
	@Value("Nhân")
	public String hoTen;
	public MonHoc monHoc;
	@Autowired
	@Qualifier("hocKi1")
	public HocKi hocKi ;
	public ArrayList<MonHoc> MonHoc = new ArrayList<>();
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public SinhVien2() {
		
	}
	public HocKi getHocKi() {
		return hocKi;
	}
	public void setHocKi(HocKi hocKi) {
		this.hocKi = hocKi;
	}
	public ArrayList<MonHoc> getMonHoc() {
		return MonHoc;
	}
	public void setMonHoc(ArrayList<MonHoc> MonHoc) {
		this.MonHoc = MonHoc;
	}
	public void heDaoTao() {	
			System.out.println(hocKi.hocKi());
	}
	public void mangSachDiHoc() {
		for(MonHoc x: MonHoc) {
			System.out.println(" "+x.mangSachDiHoc() +" "+x.giangVien());
		}
	}
}
