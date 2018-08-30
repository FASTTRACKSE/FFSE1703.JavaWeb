package bean;

public class LopHocFE implements LopHoc {
	private String tenLop;
	public LopHocFE(String tenLop) {
		this.tenLop =tenLop;
	}
	@Override
	public String lopHoc() {
		// TODO Auto-generated method stub
		return tenLop;
	}

}
