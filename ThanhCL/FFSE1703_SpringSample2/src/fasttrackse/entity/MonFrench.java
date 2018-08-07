package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonFrench implements MonHoc {
	public String mangSachDiHoc() {
		return "mang sách FRENCH đi học!";
	}
}
