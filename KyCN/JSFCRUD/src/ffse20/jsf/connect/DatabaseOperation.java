package ffse20.jsf.connect;

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

import ffse20.jsf.bean.*;

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
			String db_url ="jdbc:mysql://localhost:3306/quanlysinhvien_javaweb?useUnicode=true&characterEncoding=utf-8",
					db_userName = "quanlysinhvien",
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
				stuObj.setLop(resultSetObj.getString("student_class"));  
				stuObj.setGender(resultSetObj.getString("student_gender"));  
				stuObj.setAddress(resultSetObj.getString("student_address"));  
				stuObj.setDate(resultSetObj.getString("student_date")); 
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
			pstmt = getConnection().prepareStatement("insert into student_record (student_name, student_class, student_email, student_date, student_gender, student_address) values (?, ?, ?, ?, ?, ?)");			
			pstmt.setString(1, newStudentObj.getName());
			pstmt.setString(2, newStudentObj.getLop());
			pstmt.setString(3, newStudentObj.getEmail());
			pstmt.setString(4, newStudentObj.getDate());
			pstmt.setString(5, newStudentObj.getGender());
			pstmt.setString(6, newStudentObj.getAddress());
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
				editRecord.setGender(resultSetObj.getString("student_gender"));
				editRecord.setAddress(resultSetObj.getString("student_address"));
				editRecord.setLop(resultSetObj.getString("student_class")); 
				editRecord.setDate(resultSetObj.getString("student_date")); 
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
			pstmt = getConnection().prepareStatement("update student_record set student_name=? , student_class=?, student_email=? , student_date=?, student_gender=?, student_address=? where student_id=?");    
			pstmt.setString(1, updateStudentObj.getName());
			pstmt.setString(2, updateStudentObj.getLop());
			pstmt.setString(3, updateStudentObj.getEmail());
			pstmt.setString(4, updateStudentObj.getDate());
			pstmt.setString(5, updateStudentObj.getGender());
			pstmt.setString(6, updateStudentObj.getAddress());
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
	
	public int count() {
		try {
			PreparedStatement ps = getConnection().prepareStatement("select count(*) from student_record");
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
			PreparedStatement ps = getConnection().prepareStatement("select * from student_record limit " + (fromIndex) + "," + records);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean u = new StudentBean();
				u.setId(rs.getInt("student_id"));
				u.setName(rs.getString("student_name"));
				u.setLop(rs.getString("student_class"));
				u.setDate(rs.getString("student_date"));
				u.setGender(rs.getString("student_gender"));
				u.setEmail(rs.getString("student_email"));
				u.setAddress(rs.getString("student_address"));  
				
				list.add(u);
			}
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}