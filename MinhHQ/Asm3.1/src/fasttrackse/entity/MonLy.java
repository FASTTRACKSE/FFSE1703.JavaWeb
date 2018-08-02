package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonLy implements MonHoc{

	public String mangSachDiHoc() {
		return "hãy mang sách Lý đi học";
	}
}
