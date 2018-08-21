package fasttrackse.entity;

public class SinhVienVersion2 {
	private String hoTen;
	public MonToan monToan;
	public MonLy monLy;
	public MonHoa monHoa;
	
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public MonToan getMonToan() {
		return monToan;
	}
	public void setMonToan(MonToan monToan) {
		this.monToan = monToan;
	}
	public MonLy getMonLy() {
		return monLy;
	}
	public void setMonLy(MonLy monLy) {
		this.monLy = monLy;
	}
	public MonHoa getMonHoa() {
		return monHoa;
	}
	public void setMonHoa(MonHoa monHoa) {
		this.monHoa = monHoa;
	}
	public SinhVienVersion2(String hoTen) {
		super();
		this.hoTen = hoTen;
		monToan = new MonToan();
		monLy = new MonLy();
		monHoa = new MonHoa();
	}
	
	public String mangSachToanDiHoc() {
		return "Bạn " + hoTen + " " + monToan.mangSachDiHoc();
	}
	
	public String mangSachLyDiHoc() {
		return "Bạn " + hoTen + " " + monLy.mangSachDiHoc();
	}
	
	public String mangSachHoaDiHoc() {
		return "Bạn " + hoTen + " " + monHoa.mangSachDiHoc();
	}

}