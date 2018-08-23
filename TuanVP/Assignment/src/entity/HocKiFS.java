package entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HocKiFS implements HocKi {
	public List<MonHoc> monHoc;
	public HocKiFS() {
		super();
	}

	private String tenHocKi;

	public HocKiFS(String tenHocKi, List<MonHoc> monHoc) {
		super();
		this.tenHocKi = tenHocKi;
		this.monHoc = monHoc;
	}

	@Override
	public String tenHocKi() {
		String st = "  " + tenHocKi + "\n";
		st += "  Danh sách môn học: \n";
		for (MonHoc mH: monHoc) {
			st += "    - " + mH.mangSachDiHoc()+ "\n";
		}
		return st;
	}

}
