package tong.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tong.service.TongService;

@ManagedBean
@SessionScoped
public class TongBean {
	private int soA,soB,ketQua;
	@ManagedProperty( value = "tb")
	private TongService tinh;
	public String submit() {
		this.ketQua = tinh.sum(this.soA, this.soB);
		return "resuilt";
	}
	
	public int getSoA() {
		return soA;
	}

	public void setSoA(int soA) {
		this.soA = soA;
	}

	public int getSoB() {
		return soB;
	}

	public void setSoB(int soB) {
		this.soB = soB;
	}

	public int getKetQua() {
		return ketQua;
	}

	public void setKetQua(int ketQua) {
		this.ketQua = ketQua;
	}
	
}
