package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc {
	@Override
	public String mangSachDiHoc() {
		// TODO Auto-generated method stub
		return "Mang sách Hóa đi học";
	}
}
