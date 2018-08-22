package entity;

public class HeDaoTaoFE implements HeDaoTao{
	private String tenHDT;
	public HeDaoTaoFE(String tenHDT) {
		this.tenHDT=tenHDT;
	}
	@Override
	public String getTenHeDaoTao() {
		// TODO Auto-generated method stub
		return tenHDT;
	}

}
