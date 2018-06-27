 package net.roseindia.bean;

public class UserBean {

    private int id;
    private String fName;
    private String lName;
    private String date;
    private String cuontry;
    private String gender;
    private String Class;
        
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public String getcountry() {
		return cuontry;
	}
	public void setcountry(String country) {
		this.cuontry = country;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	public String getclass() {
		return Class;
	}
	public void setClass(String Class) {
		this.Class = Class;
	}
}