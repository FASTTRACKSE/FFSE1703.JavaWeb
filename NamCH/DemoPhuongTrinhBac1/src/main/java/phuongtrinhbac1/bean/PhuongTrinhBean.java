package phuongtrinhbac1.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import phuongtrinhbac1.service.PhuongTrinhService;

@ManagedBean
@SessionScoped
public class PhuongTrinhBean {
	@ManagedProperty(value = "#{ptService}")
	PhuongTrinhService ptService;
	private float a,b;
	private String result;
	
	public String resuilt() {
		this.result = ptService.sum(this.a,this.b);
		return "resuilt";
	}
	
	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public PhuongTrinhService getPtService() {
		return ptService;
	}

	public void setPtService(PhuongTrinhService ptService) {
		this.ptService = ptService;
	}
	
}
