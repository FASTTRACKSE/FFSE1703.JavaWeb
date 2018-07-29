package bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user_bean")
public class User_bean {
 private String userName, pass;
 	public User_bean() {
 		// 		
 	}
 
	public User_bean(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
 
 
}
