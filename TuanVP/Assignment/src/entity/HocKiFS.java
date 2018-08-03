package entity;

import org.springframework.stereotype.Component;

@Component
public class HocKiFS implements HocKi {
	public HocKiFS() {
		super();
	}

	private String tenHocKi;

	public HocKiFS(String tenHocKi) {
		super();
		this.tenHocKi = tenHocKi;
	}

	@Override
	public String tenHocKi() {
		return tenHocKi;
	}

}
