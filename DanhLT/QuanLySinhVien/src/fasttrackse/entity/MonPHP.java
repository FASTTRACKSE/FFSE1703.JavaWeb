package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonPHP implements MonHoc{
	public String mangSachDiHoc() {
		return "mang sách MonPHP đi học!";
}
	public String giangvien() {
		
		return "thay Nghia day";
	}
}
