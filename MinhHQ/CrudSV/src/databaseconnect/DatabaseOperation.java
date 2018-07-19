package databaseconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.StudentBean;

@ManagedBean(name = "Database")
@SessionScoped

public class DatabaseOperation {

	public static Statement stmtObj;
	public static Connection connObj;
	public static ResultSet resultSetObj;
	public static PreparedStatement pstmt;

	public static Connection getConnection(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");     
			String db_url ="jdbc:mysql://localhost:3306/lp5?useUnicode=true&characterEncoding=utf-8",
					db_userName = "minhad",
					db_password = "minh";
			connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
		} catch(Exception sqlException) {  
			sqlException.printStackTrace();
		}  
		return connObj;
	}

	public static ArrayList<StudentBean> getStudentsListFromDB() {
		ArrayList<StudentBean> studentsList = new ArrayList<StudentBean>();  
		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from sinh_vien");    
			while(resultSetObj.next()) {  
				StudentBean stuObj = new StudentBean(); 
				stuObj.setId(resultSetObj.getInt("student_id"));
				stuObj.setName(resultSetObj.getString("student_name"));
				stuObj.setDate(resultSetObj.getString("student_date"));
				stuObj.setGender(resultSetObj.getString("student_gender"));
				stuObj.setEmail(resultSetObj.getString("student_email"));
				stuObj.setPhone(resultSetObj.getString("student_phone"));
				stuObj.setAddress(resultSetObj.getString("student_address"));  
				stuObj.setLop(resultSetObj.getString("student_class"));  
				studentsList.add(stuObj);  
			}   
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
			pstmt = getConnection().prepareStatement("insert into sinh_vien ( student_name, student_date, student_gender, student_email, student_phone, student_address, student_class) values (?, ?, ?, ?, ?, ?, ?)");			
			pstmt.setString(1, newStudentObj.getName());
			pstmt.setString(2, newStudentObj.getDate());
			pstmt.setString(3, newStudentObj.getGender());
			pstmt.setString(4, newStudentObj.getEmail());
			pstmt.setString(5, newStudentObj.getPhone());
			pstmt.setString(6, newStudentObj.getAddress());
			pstmt.setString(7, newStudentObj.getLop());
			saveResult = pstmt.executeUpdate();
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "liststudent.xhtml?faces-redirect=true";
		} else {
			navigationResult = "creatstudent.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

	public static String editStudentRecordInDB(int studentId) {
		StudentBean editRecord = null;

		/* Setting The Particular Student Details In Session */
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		try {
			stmtObj = getConnection().createStatement();    
			resultSetObj = stmtObj.executeQuery("select * from sinh_vien where student_id = "+studentId);    
			if(resultSetObj != null) {
				resultSetObj.next();
				editRecord = new StudentBean(); 
				editRecord.setId(resultSetObj.getInt("student_id"));
				editRecord.setName(resultSetObj.getString("student_name"));
				editRecord.setDate(resultSetObj.getString("student_date"));
				editRecord.setGender(resultSetObj.getString("student_gender"));
				editRecord.setEmail(resultSetObj.getString("student_email"));
				editRecord.setPhone(resultSetObj.getString("student_phone"));
				editRecord.setAddress(resultSetObj.getString("student_address"));  
				editRecord.setLop(resultSetObj.getString("student_class"));
				
			}
			sessionMapObj.put("editRecordObj", editRecord);
			connObj.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/editstudent.xhtml?faces-redirect=true";
	}

	public static String updateStudentDetailsInDB(StudentBean updateStudentObj) {
		try {
			pstmt = getConnection().prepareStatement("update sinh_vien set student_name=?, student_date=?, student_gender=?, student_email=?, student_phone=?, student_address=?, student_class=? where student_id=?");    
			pstmt.setString(1, updateStudentObj.getName());
			pstmt.setString(2, updateStudentObj.getDate());
			pstmt.setString(3, updateStudentObj.getGender());
			pstmt.setString(4, updateStudentObj.getEmail());
			pstmt.setString(5, updateStudentObj.getPhone());
			pstmt.setString(6, updateStudentObj.getAddress());
			pstmt.setString(7, updateStudentObj.getLop()); 
			pstmt.setInt(8, updateStudentObj.getId());
			pstmt.executeUpdate();
			connObj.close();			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "/liststudent.xhtml?faces-redirect=true";
	}

	public static String deleteStudentRecordInDB(int studentId){
		try {
			pstmt = getConnection().prepareStatement("delete from sinh_vien where student_id = "+studentId);  
			pstmt.executeUpdate();  
			connObj.close();
		} catch(Exception sqlException){
			sqlException.printStackTrace();
		}
		return "/liststudent.xhtml?faces-redirect=true";
	}
	public int count() {
		try {
			PreparedStatement ps = getConnection().prepareStatement("select count(*) from sinh_vien");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			ps.close();
			return count;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public ArrayList<StudentBean> getRecords(int fromIndex, int records) {
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		try {
			PreparedStatement ps = getConnection().prepareStatement("select * from sinh_vien limit " + (fromIndex) + "," + records);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean u = new StudentBean();
				u.setId(rs.getInt("student_id"));
				u.setName(rs.getString("student_name"));
				u.setDate(rs.getString("student_date"));
				u.setGender(rs.getString("student_gender"));
				u.setEmail(rs.getString("student_email"));
				u.setPhone(rs.getString("student_phone"));
				u.setAddress(rs.getString("student_address"));  
				u.setLop(rs.getString("student_class"));
				list.add(u);
			}
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}