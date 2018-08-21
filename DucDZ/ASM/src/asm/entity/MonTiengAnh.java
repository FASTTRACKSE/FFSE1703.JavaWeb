package asm.entity;

public class MonTiengAnh implements MonHoc{
	public String tenMonHoc;
	public GiangVien gvChinh;
	public GiangVien troGiang;
	public String level;
	public MonTiengAnh() {
		
	}
	public MonTiengAnh(String tenMonHoc,String level,GiangVien gvChinh ,GiangVien troGiang) {
		super();
		this.tenMonHoc=tenMonHoc;
		this.level=level;
		this.gvChinh=gvChinh;
		this.troGiang=troGiang;
	}
	@Override
	public String tenMonHoc() {
		String tiengAnh=" - Tên Môn Học: "+tenMonHoc+"\n";
		tiengAnh+=" - Giảng Viên Chính: "+gvChinh+"\n";
		tiengAnh+=" - Trợ Giảng: "+troGiang+"\n";
		return tiengAnh;
	}
	
}
