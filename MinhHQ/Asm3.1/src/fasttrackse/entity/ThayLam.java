package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class ThayLam implements GiangVien{

	@Override
	public String giangVien() {
		return "Thầy Lâm";
	}

}
