package entity;

public class LopHoc implements Lop{
	private String tenL;
	public LopHoc(String tenLop) {
		// TODO Auto-generated constructor stub
		this.tenL = tenLop;
	}
	@Override
	public void getTenLop() {
		// TODO Auto-generated method stub
		System.out.println(tenL);
	}
	public String getTenL() {
		return tenL;
	}
	public void setTenLop(String tenLop) {
		this.tenL = tenLop;
	}
}
