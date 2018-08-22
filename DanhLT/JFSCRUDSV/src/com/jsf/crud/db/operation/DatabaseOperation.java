package com.jsf.crud.db.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.jsf.crud.StudentBean;

@ManagedBean(name = "data")
@SessionScoped
public class DatabaseOperation {

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;

	public static Connection getConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");     
			String db_url ="jdbc:mysql://localhost:3306/LP5?useUnicode=true&characterEncoding=utf-8",
					db_userName = "admin",
					db_password = "12345";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}

	public static ArrayList getStudentsListFromDB() {
		ArrayList studentsList = new ArrayList();  
		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from student_record");    
			while(resultSetObj.next()) {  
				StudentBean stuObj = new StudentBean(); 
				stuObj.setId(resultSetObj.getInt("student_id"));  
				stuObj.setName(resultSetObj.getString("student_name"));  
				stuObj.setEmail(resultSetObj.getString("student_email"));  
				stuObj.setLop(resultSetObj.getString("student_lop"));
				stuObj.setDate(resultSetObj.getString("student_date"));
				stuObj.setPhone(resultSetObj.getString("student_phone"));
				stuObj.setGender(resultSetObj.getString("student_gender"));  
				stuObj.setAddress(resultSetObj.getString("student_address"));  
				studentsList.add(stuObj);  
			}   
			System.out.println("Total Records Fetched: " + studentsList.size());
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		} 
		return studentsList;
	}

	public static String saveStudentDetailsInDB(StudentBean newStudentObj) {
		int saveResult = 0;
		String navigationResult = "";
		try {      
			pstmt = getConnection().prepareStatement("insert into student_record (student_name, student_email, student_lop, student_date, student_phone, student_gender, student_address) values (?, ?, ?, ?, ?, ?, ?)");			
			pstmt.setString(1, newStudentObj.getName());
			pstmt.setString(2, newStudentObj.getEmail());
			pstmt.setString(3, newStudentObj.getLop());
			pstmt.setString(4, newStudentObj.getDate());
			pstmt.setString(5, newStudentObj.getPhone());
			pstmt.setString(6, newStudentObj.getGender());
			pstmt.setString(7, newStudentObj.getAddress());
			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "studentsList.xhtml?faces-redirect=true";
		} else {
			navigationResult = "createStudent.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	public static String editStudentRecordInDB(int studentId) {
		StudentBean editRecord = null;
		System.out.println("editStudentRecordInDB() : Student Id: " + studentId);

		/* Setting The Particular Student Details In Session */
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from student_record where student_id = "+studentId);    
			if(resultSetObj != null) {
				resultSetObj.next();
				editRecord = new StudentBean(); 
				editRecord.setId(resultSetObj.getInt("student_id"));
				editRecord.setName(resultSetObj.getString("student_name"));
				editRecord.setEmail(resultSetObj.getString("student_email"));
				editRecord.setLop(resultSetObj.getString("student_lop"));
				editRecord.setDate(resultSetObj.getString("student_date"));
				editRecord.setPhone(resultSetObj.getString("student_phone"));
				editRecord.setGender(resultSetObj.getString("student_gender"));
				editRecord.setAddress(resultSetObj.getString("student_address")); 
			}
			sessionMapObj.put("editRecordObj", editRecord);
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editStudent.xhtml?faces-redirect=true";
	}

	public static String updateStudentDetailsInDB(StudentBean updateStudentObj) {
		try {
			pstmt = getConnection().prepareStatement("update student_record set student_name=?, student_email=?, student_lop=?, student_date=?, student_phone=?, student_gender=?, student_address=? where student_id=?");    
			pstmt.setString(1,updateStudentObj.getName());  
			pstmt.setString(2,updateStudentObj.getEmail());  
			pstmt.setString(3,updateStudentObj.getLop());  
			pstmt.setString(4,updateStudentObj.getDate());  
			pstmt.setString(5,updateStudentObj.getPhone()); 
			pstmt.setString(6,updateStudentObj.getGender());  
			pstmt.setString(7,updateStudentObj.getAddress()); 
			
			pstmt.setInt(8,updateStudentObj.getId()); 
			
			pstmt.executeUpdate();
			connObj.close();			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}

	public static String deleteStudentRecordInDB(int studentId){
		System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
		try {
			pstmt = getConnection().prepareStatement("delete from student_record where student_id = "+studentId);  
			pstmt.executeUpdate();  
			connObj.close();
		} catch(Exception sqlException){
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}
	public int count() throws SQLException {
		int count = 0;
	
		String sql = "select count(student_id) from student_record";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			count = rs.getInt("count(student_id)");
		}
		return count;
	}



	public ArrayList<StudentBean> getRecords(int fromIndex, int records) {
		ArrayList<StudentBean> sinhVienList = new ArrayList<StudentBean>();
		try {
		
			PreparedStatement ps = getConnection().prepareStatement("select * from student_record limit " + fromIndex + "," + records);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean e = new StudentBean();
				e.setId(rs.getInt("student_id"));
				e.setName(rs.getString("student_name"));
				e.setDate(rs.getString("student_date"));
				e.setEmail(rs.getString("student_email"));
				e.setLop(rs.getString("student_lop"));
				e.setGender(rs.getString("student_gender"));
				e.setPhone(rs.getString("student_phone"));
				e.setAddress(rs.getString("student_address"));
				sinhVienList.add(e);
			}
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return sinhVienList;
	}
}