package sinhvien.jsf.db.operations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import sinhvien.jsf.bean.SinhvienBean;



public class DatabaseOperation {

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;

	public static Connection getConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");     
			String db_url ="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8",
					db_userName = "admin1",
					db_password = "12345";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}
	
	public static ArrayList<SinhvienBean> getStudentsListFromDB() {
		ArrayList<SinhvienBean> listSinhvien = new ArrayList<SinhvienBean>();  
		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("SELECT * FROM student ");    
			while(resultSetObj.next()) {  
				SinhvienBean sv = new SinhvienBean(); 
				sv.setId(resultSetObj.getInt("id"));  
				sv.setHodem(resultSetObj.getString("student_hodem"));
				sv.setTen(resultSetObj.getString("student_ten"));
				sv.setNamsinh(resultSetObj.getString("student_namsinh"));
				sv.setGioitinh(resultSetObj.getString("student_gioitinh"));
				sv.setEmail(resultSetObj.getString("student_emaill"));
				sv.setDienthoai(resultSetObj.getString("student_dienthoai"));
				sv.setDiachi(resultSetObj.getString("student_diachi"));
				sv.setLop(resultSetObj.getString("student_lop")); 
				listSinhvien.add(sv);  
			
			}   
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		} 
		return listSinhvien;
	}
	public static String addSinhvien(SinhvienBean newSinhvien) {
		int saveResult = 0;
		String navigationResult = "";
		try {      
			pstmt = getConnection().prepareStatement("INSERT INTO student ( student_hodem, student_ten, student_namsinh, student_gioitinh, student_email, student_dienthoai,student_diachi, student_lop) VALUES (?,?,?,?,?,?,?,?)");			
			pstmt.setString(1, newSinhvien.getHodem());
			pstmt.setString(2, newSinhvien.getTen());
			pstmt.setString(3, newSinhvien.getNamsinh());
			pstmt.setString(4, newSinhvien.getGioitinh());
			pstmt.setString(5, newSinhvien.getEmail());
			pstmt.setString(6, newSinhvien.getDienthoai());
			pstmt.setString(7, newSinhvien.getDiachi());
			pstmt.setString(8, newSinhvien.getLop());
			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "listSinhvien.xhtml?faces-redirect=true";
		} else {
			navigationResult = "addSinhvien.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	public static String editSinhvien(int studentId) {
		SinhvienBean editSinhvien = null;
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from student where id = "+studentId);    
			if(resultSetObj != null) {
				resultSetObj.next();
				editSinhvien = new SinhvienBean(); 
				editSinhvien.setId(resultSetObj.getInt("id"));
				editSinhvien.setHodem(resultSetObj.getString("student_hodem"));
				editSinhvien.setTen(resultSetObj.getString("student_ten"));
				editSinhvien.setNamsinh(resultSetObj.getString("student_namsinh"));
				editSinhvien.setGioitinh(resultSetObj.getString("student_gioitinh"));
				editSinhvien.setEmail(resultSetObj.getString("student_emaill"));
				editSinhvien.setDienthoai(resultSetObj.getString("student_dienthoai"));
				editSinhvien.setDiachi(resultSetObj.getString("student_diachi"));
				editSinhvien.setLop(resultSetObj.getString("student_lop"));
			}
			sessionMapObj.put("editSinhvien", editSinhvien);
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editStudent.xhtml?faces-redirect=true";
	}

	public static String updateSinhvien(SinhvienBean updateSinhvien) {
		try {
			pstmt = getConnection().prepareStatement("update student set student_hodem=?, student_ten=?, student_namsinh=?, student_gioitinh=?, student_emaill=?, student_dienthoai=?, student_diachi=?, student_lop=? where id=?");    
			pstmt.setString(1,updateSinhvien.getHodem());  
			pstmt.setString(2, updateSinhvien.getTen());
			pstmt.setString(3, updateSinhvien.getNamsinh());
			pstmt.setString(4, updateSinhvien.getGioitinh());
			pstmt.setString(5, updateSinhvien.getEmail());
			pstmt.setString(6, updateSinhvien.getDienthoai());
			pstmt.setString(7, updateSinhvien.getDiachi());
			pstmt.setString(8, updateSinhvien.getLop());
			pstmt.setInt(9,updateSinhvien.getId());  
			pstmt.executeUpdate();
			connObj.close();			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/listSinhvien.xhtml?faces-redirect=true";
	}

	public static String deleteSinhvien(int studentId){
		try {
			pstmt = getConnection().prepareStatement("delete from student where id = "+studentId);  
			pstmt.executeUpdate();  
			connObj.close();
		} catch(Exception sqlException){
			sqlException.printStackTrace();
		}
		return "/listSinhvien.xhtml?faces-redirect=true";
	}
}
