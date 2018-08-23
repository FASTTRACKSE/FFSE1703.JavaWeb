package entity;


public class GiangVienFE implements GiangVien{
	private String tenGV;
	
	public GiangVienFE(String tenGV) {
		this.tenGV=tenGV;
	}	
	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return tenGV+" ";
	}
	
}
