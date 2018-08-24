package com.javatpoint.beans;  
  
public class Emp {  
private int id,maSV;  
private String tenSV,email,diaChi,lopHoc,namSinh, avatar;
  
public String getAvatar() {
	return avatar;
}
public void setAvatar(String avatar) {
	this.avatar = avatar;
}
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}
public String getNamSinh() {
	return namSinh;
}
public void setNamSinh(String namSinh) {
	this.namSinh = namSinh;
}
public int getMaSV() {
	return maSV;
}
public void setMaSV(int maSV) {
	this.maSV = maSV;
}
public String getTenSV() {
	return tenSV;
}
public void setTenSV(String tenSV) {
	this.tenSV = tenSV;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getLopHoc() {
	return lopHoc;
}
public void setLopHoc(String lopHoc) {
	this.lopHoc = lopHoc;
}  

}