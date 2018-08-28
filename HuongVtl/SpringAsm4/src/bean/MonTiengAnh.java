package bean;

import java.util.ArrayList;

public class MonTiengAnh implements MonHoc{
	private String trinhDo;
	private ArrayList<GiangVien>arrGv;
	public MonTiengAnh(String trinhDo, ArrayList<GiangVien>arrGv) {
		this.trinhDo = trinhDo;
		this.arrGv = arrGv;
	}
	@Override
	public String monHoc() {
		// TODO Auto-generated method stub
		String a ="";
		for(GiangVien x: arrGv) {
			a = a+x.tenGiangVien();
		}
		return "môn tiếng anh\n"+trinhDo+"\n"+a;
	}

}
