package fasttrackse.entity;

public class SinhVienVersion5 {
	private String hoTen;
	public MonHoc monHoc;	
	public HeDaoTao heDaotao;
	
	
	
	public HeDaoTao getHeDaotao() {
		return heDaotao;
	}
	public void setHeDaotao(HeDaoTao heDaotao) {
		this.heDaotao = heDaotao;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	
	public SinhVienVersion5(String hoTen) {
		super();
		this.hoTen = hoTen;
	}
	
	public String mangSachDiHoc() {
		return "Bạn " + hoTen + " " + monHoc.mangSachDiHoc();
	}
	public String khoaDaoTao() {
		System.out.println("Bạn " + hoTen + ": ");
		return heDaotao.khoaDaoTao();
		
		
	}
}
