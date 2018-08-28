package bean;

public class TenHeDaoTao implements HeDaoTao{
	private String tenHeDT;
	public TenHeDaoTao(String tenHeDT) {
		this.tenHeDT = tenHeDT;
	}
	@Override
	public String heDaoTao() {
		// TODO Auto-generated method stub
		return tenHeDT;
	}

}
