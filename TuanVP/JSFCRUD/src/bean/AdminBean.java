package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminBean {
	public String admin, password;

	public AdminBean() {

	}

	public AdminBean(String admin, String password) {
		this.admin = admin;
		this.password = password;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
