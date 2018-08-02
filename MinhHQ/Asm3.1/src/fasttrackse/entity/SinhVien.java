package fasttrackse.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SinhVien {
	private String hoTen;
	private List<MonHoc> monHoc;
	
	
	@Autowired
	@Qualifier("daoTaoDaiHan")
	private HeDaoTao heDaoTao;
	private GiangVien giaovien;
	
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String name) {
		hoTen = name;
	}
	
	public List<MonHoc> getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(List<MonHoc> monHoc) {
		this.monHoc = monHoc;
	}
	
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	public GiangVien getGiaovien() {
		return giaovien;
	}

	public void setGiaovien(GiangVien giaovien) {
		this.giaovien = giaovien;
	}

	public String mangSachDiHoc() {
		String result = "Bạn " + hoTen + ": ";
		result += "\n" + heDaoTao.getGioHoc();
		for (MonHoc x : monHoc) {
			if(x instanceof MonToan) {
				result += "\n\t- " + x.mangSachDiHoc() +" do Thầy Thành dạy";
			}else if(x instanceof MonLy) {
				result += "\n\t- " + x.mangSachDiHoc() +" do Thầy Lâm dạy";
			}else if(x instanceof MonHoa) {
				result += "\n\t- " + x.mangSachDiHoc() +" do Thầy Thắng dạy";
			}else if(x instanceof MonEnglish) {
				result += "\n\t- " + x.mangSachDiHoc() +" do Cô Quyên dạy";
			}else if(x instanceof MonFrench) {
				result += "\n\t- " + x.mangSachDiHoc() +" do Cô Hương dạy";
			} else{
				result += "\n\t- " + x.mangSachDiHoc();
			}
			
		}
		
		return result;
	}
}
