package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "paginator")
@SessionScoped

public class Paginator {
	public int trang,end, soTrang;
	public double tongSv,soHocSinhMotTrang;
	
	public void paginator(double tongSv){
		if(this.trang == 0) {
			this.trang = 1;
		}
		
		this.tongSv = tongSv;
		soHocSinhMotTrang = 4.0;
		
		this.end = (int) soHocSinhMotTrang;
		this.soTrang =  (int) Math.ceil(tongSv / soHocSinhMotTrang);
		System.out.println("so tran la " + this.soTrang);
		if(this.trang > this.soTrang) {
			this.trang = this.soTrang;
		}
		
	}
	
	
	public void next() {
		if(this.trang < this.soTrang) {
			this.trang += 1;
		}
	}
	
	public void prev() {
		if(this.trang > 1) {
			this.trang -= 1;
		}
	}
	
	public void first() {
		this.trang = 1;
	}
	
	public void last() {
		this.trang = this.soTrang;
	}
	
	
	
	
	public int getTrang() {
		return trang;
	}
	public void setTrang(int trang) {
		this.trang = trang;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public double getTongSv() {
		return tongSv;
	}
	public void setTongSv(double tongSv) {
		this.tongSv = tongSv;
	}
	public int start() {
		return (this.trang - 1) * (int)soHocSinhMotTrang;
	}
	
}
