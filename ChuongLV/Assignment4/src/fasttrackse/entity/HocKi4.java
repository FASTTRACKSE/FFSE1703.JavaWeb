package fasttrackse.entity;

//import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HocKi4 implements HocKi {
	private MonThucTap monThucTap;

	public HocKi4() {
		
	}



	public MonThucTap getMonThucTap() {
		return monThucTap;
	}



	public void setMonThucTap(MonThucTap monThucTap) {
		this.monThucTap = monThucTap;
	}



	@Override
	public String thongTinHocKi() {
		String result = "- Học kì thực tập \n    + Môn thực tập : ";
		result +=  monThucTap.chonMonHoc();
		return result;
	}

}
