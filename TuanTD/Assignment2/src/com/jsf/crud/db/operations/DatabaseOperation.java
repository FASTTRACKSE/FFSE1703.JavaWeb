package com.jsf.crud.db.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.jsf.crd.StudentBean;

public class DatabaseOperation {

	public  Statement stmtObj;
	public  Connection connObj;
	public  ResultSet resultSetObj;
	public  PreparedStatement pstmt;
	double total;

	public  Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db_url = "jdbc:mysql://" + "localhost" + "/" + "student"
					+ "?useUnicode=true&characterEncoding=utf-8", db_userName = "student", db_password = "12345";
			connObj = DriverManager.getConnection(db_url, db_userName, db_password);
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return connObj;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public  ArrayList getStudentsListFromDB(int start, int end) {
		ArrayList studentsList = new ArrayList();
		try {
			PreparedStatement ps = getConnection().prepareStatement("select * from student limit ?,?");
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet resultSetObj=ps.executeQuery();
			while (resultSetObj.next()) {
				StudentBean stuObj = new StudentBean();
				stuObj.setId(resultSetObj.getInt("id"));
				stuObj.setName(resultSetObj.getString("name"));
				stuObj.setClas(resultSetObj.getString("class"));
				stuObj.setEmail(resultSetObj.getString("email"));
				stuObj.setPhone(resultSetObj.getString("phone"));
				stuObj.setAddress(resultSetObj.getString("address"));
				stuObj.setAge(resultSetObj.getString("age"));
				stuObj.setGender(resultSetObj.getString("author"));
				studentsList.add(stuObj);
			}
			System.out.println("Total Records Fetched: " + studentsList.size());
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return studentsList;
	}

	public  String saveStudentDetailsInDB(StudentBean newStudentObj) {
		int saveResult = 0;
		String navigationResult = "";
		try {
			String sql = "INSERT INTO student (name, class, email, phone, address, age, author) values (?, ?, ?, ?, ?, ?, ?)";
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, newStudentObj.getName());
			pstmt.setString(2, newStudentObj.getClas());
			pstmt.setString(3, newStudentObj.getEmail());
			pstmt.setString(4, newStudentObj.getPhone());
			pstmt.setString(5, newStudentObj.getAddress());
			pstmt.setString(6, newStudentObj.getAge());
			pstmt.setString(7, newStudentObj.getGender());

			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		if (saveResult != 0) {
			navigationResult = "studentsList.xhtml?faces-redirect=true";
		} else {
			navigationResult = "createStudent.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	public  String editStudentRecordInDB(int studentId) {
		StudentBean editRecord = null;
		System.out.println("editStudentRecordInDB() : Student Id: " + studentId);

		/* Setting The Particular Student Details In Session */
		Map<String, Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		try {
			stmtObj = getConnection().createStatement();
			resultSetObj = stmtObj.executeQuery("select * from student where id = " + studentId);
			if (resultSetObj != null) {
				resultSetObj.next();
				editRecord = new StudentBean();
				editRecord.setId(resultSetObj.getInt("id"));
				editRecord.setName(resultSetObj.getString("name"));
				editRecord.setClas(resultSetObj.getString("class"));
				editRecord.setEmail(resultSetObj.getString("email"));
				editRecord.setPhone(resultSetObj.getString("phone"));
				editRecord.setAddress(resultSetObj.getString("address"));
				editRecord.setAge(resultSetObj.getString("age"));
				editRecord.setGender(resultSetObj.getString("author"));
			}
			sessionMapObj.put("editRecordObj", editRecord);
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editStudent.xhtml?faces-redirect=true";
	}

	public  String updateStudentDetailsInDB(StudentBean updateStudentObj) {
		try {
			pstmt = getConnection().prepareStatement(
					"update student set name=?, class=?, email=?, phone=?, address=?, age=?, author=? where id=?");
			pstmt.setString(1, updateStudentObj.getName());
			pstmt.setString(2, updateStudentObj.getClas());
			pstmt.setString(3, updateStudentObj.getEmail());
			pstmt.setString(4, updateStudentObj.getPhone());
			pstmt.setString(5, updateStudentObj.getAddress());
			pstmt.setString(6, updateStudentObj.getAge());
			pstmt.setString(7, updateStudentObj.getGender());
			pstmt.setInt(8, updateStudentObj.getId());
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}

	public  String deleteStudentRecordInDB(int studentId) {
		System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
		try {
			pstmt = getConnection().prepareStatement("delete from student where id = " + studentId);
			pstmt.executeUpdate();
			connObj.close();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/studentsList.xhtml?faces-redirect=true";
	}
	
	public double count() {
		try {
			String sql = "select count(*) AS total from student";
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
