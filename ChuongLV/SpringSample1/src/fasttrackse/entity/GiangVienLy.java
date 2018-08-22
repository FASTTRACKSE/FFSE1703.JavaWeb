package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class GiangVienLy implements GiangVien {

	@Override
	public String tenGiangVien() {
		return "Trong vòng 16 tháng, mời bạn đi học sáng từ 8h00, chiều từ 13h30";
	}

}