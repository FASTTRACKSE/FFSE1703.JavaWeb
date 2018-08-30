package main;

import java.util.ArrayList;

import bean.*;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiangVien gvJava = new GiangVienSE("a","b@gmail.com");
		GiangVien gvPHP = new GiangVienSE("c","d@gmail.com");
		GiangVien gvWeb = new GiangVienSE("h","g@gmail.com");
		GiangVien gvHTML = new GiangVienSE("e","k@gmail.com");
		GiangVien gvCSS = new GiangVienSE("m","n@gmail.com");
		GiangVien gvTAnh = new GiangVienSE("x","z@gmail.com");
		GiangVien gvTGTAnh = new GiangVienSE("12","23@gmail.com");
		GiangVien gvThucTap = new GiangVienSE("34","56@gmail.com");
		
		ArrayList<MonHoc>arrMhCNK1=new ArrayList<MonHoc>();
		arrMhCNK1.add(new MonCNNho("html", gvHTML));
		arrMhCNK1.add(new MonCNNho("css", gvCSS));
		
		ArrayList<MonHoc>arrMhCNK2=new ArrayList<MonHoc>();
		arrMhCNK2.add(new MonCNNho("PHP", gvPHP));
		arrMhCNK2.add(new MonCNNho("java", gvJava));
		
		ArrayList<MonHoc>arrMhCNK3=new ArrayList<MonHoc>();
		arrMhCNK3.add(new MonCNNho("java", gvJava));
		arrMhCNK3.add(new MonCNNho("web", gvWeb));
		
		ArrayList<MonHoc>arrMhJava=new ArrayList<MonHoc>();
		arrMhJava.add(new MonCNNho("Java", gvJava));
		arrMhJava.add(new MonCNNho("web", gvWeb));
		
		ArrayList<MonHoc>arrMhWeb=new ArrayList<MonHoc>();
		arrMhWeb.add(new MonCNNho("html", gvHTML));
		arrMhWeb.add(new MonCNNho("CSS", gvCSS));
		arrMhWeb.add(new MonCNNho("php", gvPHP));
		
		ArrayList<GiangVien> arrGVTA  = new ArrayList<GiangVien>();
		arrGVTA.add(gvTAnh);
		arrGVTA.add(gvTGTAnh);
		
		MonHoc monTAnhK1 =  new MonTiengAnh("lever 1", arrGVTA);
		MonHoc monTAnhK2 =  new MonTiengAnh("lever 2", arrGVTA);
		
		MonHoc monTt =new MonThucTap("FPT",gvThucTap);
		
		ArrayList<MonHoc> arrHK1  = new ArrayList<MonHoc>();
		arrHK1.add(new MonCongNghe(arrMhCNK1));
		arrHK1.add(monTAnhK1);
		HocKy hocKy1 =new HocKy1(arrHK1);
		
		ArrayList<MonHoc> arrHK2  = new ArrayList<MonHoc>();
		arrHK2.add(new MonCongNghe(arrMhCNK2));
		arrHK2.add(monTAnhK2);
		HocKy hocKy2=new HocKy2(arrHK2);
		
		HocKy hocKy3 = new HocKy3(new MonCongNghe(arrMhCNK3));
		HocKy hocKy4 = new HocKy4(monTt);
		HocKy hocKyJava = new HocKyJava(new MonCongNghe(arrMhJava));
		HocKy hocKyWeb = new HocKyJava(new MonCongNghe(arrMhWeb));
		
		ArrayList<HocKy> arrDH  = new ArrayList<HocKy>();
		arrDH.add(hocKy1);
		arrDH.add(hocKy2);
		arrDH.add(hocKy3);
		arrDH.add(hocKy4);
		HeDaoTao heDaoTaoDH = new HeDaoTaoDai(arrDH);
		
		ArrayList<HocKy> arrNH  = new ArrayList<HocKy>();
		arrNH.add(hocKyJava);
		arrNH.add(hocKyWeb);
		HeDaoTao heDaoTaoNH = new HeDaoTaoNgan(arrNH);
		
		LopHoc lop1703=new LopHoc();
		lop1703.setTenLop("ffse1703");
		lop1703.setHeDaoTao(heDaoTaoDH);
		
		ArrayList<SinhVien> arrSv  = new ArrayList<SinhVien>();
		arrSv.add(new SinhVien("h","h@gmail.com","phố 3", "012374859"));
		arrSv.add(new SinhVien("a","a@gmail.com","phố 1", "012374859"));
		arrSv.add(new SinhVien("b","b@gmail.com","phố 2", "012374859"));
		
		lop1703.setArrSv(arrSv);
		
		LopHoc lop1801 = new LopHoc();
		lop1801.setTenLop("ffse1801");
		lop1801.setHeDaoTao(heDaoTaoNH);
		
		ArrayList<SinhVien>arrSv1 = new ArrayList<SinhVien>();
		arrSv1.add(new SinhVien("h","h@gmail.com","phố 3", "012374859"));
		
		lop1801.setArrSv(arrSv);
		
		lop1703.inThongTin();
		lop1801.inThongTin();
		
	}

}
