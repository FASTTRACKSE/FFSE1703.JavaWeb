package bean;

public class MonThucTap implements MonHoc{
	private String tenCty;
	private GiangVien giangVien;
	public MonThucTap(String tenCty, GiangVien giangVien) {
		this.tenCty = tenCty;
		this.giangVien =giangVien;
	}
	
	@Override
	public String monHoc() {
		// TODO Auto-generated method stub
		return "môn thực tập\n"+tenCty+" - "+giangVien.tenGiangVien();
	}

}
