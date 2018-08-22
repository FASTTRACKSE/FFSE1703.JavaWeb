package FFSE;

public class TiengAnh implements MonHoc{

	public String tenMonHoc, trinhDo;
	public GiangVienChinh giangVienChinh;
	public TroGiang troGiang;

	public TiengAnh() {
		super();
	}

	public TiengAnh(String tenMonHoc, String trinhDo, GiangVienChinh giangVienChinh, TroGiang troGiang) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.trinhDo = trinhDo;
		this.giangVienChinh = giangVienChinh;
		this.troGiang = troGiang;
	}

	@Override
	public String getMonHoc() {
		String st = "  - Tên môn học: " + tenMonHoc + " - " + trinhDo + "\n";
		st += "   + " + giangVienChinh.thongTinGiangVien();
		st += "   + " + troGiang.thongTinGiangVien();
		return st;
	}

}
