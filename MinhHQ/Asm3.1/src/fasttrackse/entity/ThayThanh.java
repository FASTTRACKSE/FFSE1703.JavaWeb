package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class ThayThanh implements GiangVien{

	@Override
	public String giangVien() {
		return "Thầy Thành";
	}

}
