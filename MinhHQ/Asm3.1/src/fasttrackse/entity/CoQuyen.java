package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class CoQuyen implements GiangVien{

	@Override
	public String giangVien() {
		return "Cô Quyên";
	}

}
