package bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhVien {
	private String hoTen;
	private MonHoc monHoc;
	private LopHoc lopHoc;
	private HocKy hocKy;
	
	@Autowired
	@Qualifier("heDaoTaoNganHan")
	private HeDaoTao heDaoTao;
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public LopHoc getLopHoc() {
		return lopHoc;
	}
	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}
	public HocKy getHocKy() {
		return hocKy;
	}
	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
	public String mangSachDiHoc() {
		return "Bạn "+hoTen +" nho mang sach " + monHoc.mangSachDiHoc()+" "+monHoc.giangVien();
	}
	public String heDaoTao() {
		return "Bạn học hệ "+heDaoTao.heDaoTao();
	}
	public String inThongTin() {
		return "Bạn "+hoTen+" " +lopHoc.lopHoc()+" "+hocKy.hocKi()+" "+" nhớ mang sách " + monHoc.mangSachDiHoc()+" "+monHoc.giangVien()+" bạn học"+" " +heDaoTao.heDaoTao();
	}
}
