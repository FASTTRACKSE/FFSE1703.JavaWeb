package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonEnglish implements MonHoc {
	public String mangSachDiHoc() {
		return "mang sách ENGLISH đi học!";
	}
}
