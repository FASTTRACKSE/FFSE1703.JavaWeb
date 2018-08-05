package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc{
	public String mangSachDiHoc() {
		return "hãy mang sách Hoá đi học" ;
	}
}
