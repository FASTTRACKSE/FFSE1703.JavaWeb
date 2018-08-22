package com.jsf.crud;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name= "paginator")
@SessionScoped
public class Paginator {
	public int end;
	public double tongSv;
	public int trang, soTrang;
	public double soBanGhiMotTrang;
	private static final int DEFAULT_PAGE_INDEX = 1;
	
	

	public void pagination(double tongSv) {
		this.trang = DEFAULT_PAGE_INDEX;
		this.tongSv = tongSv;
		soBanGhiMotTrang = 2.0;
		
		this.end = (int)soBanGhiMotTrang;
		
		
		this.soTrang = (int)Math.ceil(this.tongSv/soBanGhiMotTrang);
		System.out.println("so trang la: " + this.soTrang);
		
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

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public void setTongSv(double tongSv) {
		this.tongSv = tongSv;
	}
	

	public int start() {
		return (this.trang - 1) * (int)soBanGhiMotTrang;
	}

	

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public double getTongSv() {
		return tongSv;
	}

	
	
	
}
