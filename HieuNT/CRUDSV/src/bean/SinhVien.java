package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "sinhVienBean")
@RequestScoped


public class SinhVien {
	private String maSinhVien;
	private String name;
	public SinhVien() {
		
	}
	public SinhVien (String maSinhVien,String name,String sex,String age,String lop,String dress) {
		this.maSinhVien=maSinhVien;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.lop=lop;
		this.dress=dress;
		
	}
	public String getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getDress() {
		return dress;
	}
	public void setDress(String dress) {
		this.dress = dress;
	}
	private String sex;
	private String age;
	private String lop;
	private String dress;

}
