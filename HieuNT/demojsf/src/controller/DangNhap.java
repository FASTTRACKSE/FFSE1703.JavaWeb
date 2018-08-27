package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DangNhap {
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username;
	private String password;

	public DangNhap() {

	}

	public DangNhap(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String dangNhap() {
		if(this.username.equals("nguyenthanhhieu") && this.password.equals("hieulinh577")) {
			return "welcom.xhtml";
		}
		return password;
		
	}
}
