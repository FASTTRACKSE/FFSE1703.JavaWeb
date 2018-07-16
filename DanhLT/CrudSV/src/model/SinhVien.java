package model;

public class SinhVien {

	protected String maSV;
	protected String name;
	protected String sex;
	protected String age;
	protected String cls;
	protected String dress;
    
    public SinhVien() {
    }
  
	public SinhVien(String maSV, String name,String sex, String age, String cls, String dress) {
		this.maSV = maSV;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.cls = cls;
		this.dress = dress;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMaSV() {
		return maSV;
	}


	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getCls() {
		return cls;
	}


	public void setCls(String cls) {
		this.cls = cls;
	}


	public String getDress() {
		return dress;
	}


	public void setDress(String dress) {
		this.dress = dress;
	}

}