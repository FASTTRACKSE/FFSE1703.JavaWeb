package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class NhapMonLapTrinh implements MonHoc{

	@Override
	public String chonMonHoc() {
		return "Nhập môn LT - Thầy Thắng";
	}

}
