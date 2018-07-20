package com.jsf.crud.db.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.jsf.crud.StudentBean;

public class DatabaseOperation {

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;
	double total;
	public static Connection getConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");     
			String db_url ="jdbc:mysql://localhost:3306/students",
					db_userName = "thanhlong123",
					db_password = "123456";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList getStudentsListFromDB(int start, int end) {
		ArrayList studentsList = new ArrayList();  
		try {
			PreparedStatement ps = getConnection().prepareStatement("select * from student_record limit ?,?");
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet resultSetObj=ps.executeQuery();  
			while(resultSetObj.next()) {  
				StudentBean stuObj = new StudentBean(); 
				stuObj.setId(resultSetObj.getInt("student_id"));  
				stuObj.setName(resultSetObj.getString("student_name"));  
				stuObj.setEmail(resultSetObj.getString("student_email"));  
				stuObj.setPassword(resultSetObj.getString("student_password"));  
				stuObj.setGender(resultSetObj.getString("student_gender"));  
				stuObj.setPhone(resultSetObj.getString("student_phone"));
				stuObj.setAddress(resultSetObj.getString("student_address")); 
				stuObj.setLop(resultSetObj.getString("student_class")); 
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
			pstmt = getConnection().prepareStatement("insert into student_record (student_name, student_email, student_password, student_gender,student_phone, student_address,student_class) values (?, ?, ?, ?,?,?,?)");			
			pstmt.setString(1, newStudentObj.getName());
			pstmt.setString(2, newStudentObj.getEmail());
			pstmt.setString(3, newStudentObj.getPassword());
			pstmt.setString(4, newStudentObj.getGender());
			pstmt.setString(5, newStudentObj.getPhone());
			pstmt.setString(6, newStudentObj.getAddress());
			pstmt.setString(7, newStudentObj.getLop());
			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult > 0) {
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
				editRecord.setPassword(resultSetObj.getString("student_password")); 
				editRecord.setGender(resultSetObj.getString("student_gender"));
				editRecord.setPhone(resultSetObj.getString("student_phone"));
				editRecord.setAddress(resultSetObj.getString("student_address"));
				editRecord.setLop(resultSetObj.getString("student_class"));
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
			pstmt = getConnection().prepareStatement("update student_record set student_name=?, student_email=?, "
					+ "student_password=?, student_gender=?, "
					+ "Student_phone=?, student_address=?, student_class=?  where student_id=?");    
			pstmt.setString(1,updateStudentObj.getName());  
			pstmt.setString(2,updateStudentObj.getEmail());  
			pstmt.setString(3,updateStudentObj.getPassword());  
			pstmt.setString(4,updateStudentObj.getGender());
			pstmt.setString(5,updateStudentObj.getPhone());
			pstmt.setString(6,updateStudentObj.getAddress());  
			pstmt.setString(7,updateStudentObj.getLop());  
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
	public double count() {
		try {
			String sql = "select count(*) AS total from student_record";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet result= ps.executeQuery();
			while(result.next())
			{
				total = result.getDouble("total");
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return total;
	}
	
}