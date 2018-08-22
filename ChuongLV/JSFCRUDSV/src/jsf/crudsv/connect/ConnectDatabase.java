package jsf.crudsv.connect;
 

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.Map;

 

import javax.faces.context.FacesContext;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

 

import jsf.crudsv.bean.*;

@ManagedBean(name = "Database")
@SessionScoped

 

public class ConnectDatabase {

 

    public static Statement stmtObj;

    public static Connection connObj;

    public static ResultSet resultSetObj;

    public static PreparedStatement pstmt;

 

    public static Connection getConnection(){ 

        try{ 

            Class.forName("com.mysql.jdbc.Driver");    

            String db_url ="jdbc:mysql://localhost:3306/vanchuong?useUnicode=true&characterEncoding=utf-8",

                    db_userName = "vanchuong",

                    db_password = "123456";

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

                stuObj.setDate(resultSetObj.getString("student_date")); 

                stuObj.setGender(resultSetObj.getString("student_gender"));
                
                stuObj.setLop(resultSetObj.getString("student_class"));

                stuObj.setAddress(resultSetObj.getString("student_address"));
                
                stuObj.setPhone(resultSetObj.getString("student_phone"));

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

            pstmt = getConnection().prepareStatement("insert into student_record (student_name, student_email, student_date, student_gender, student_class, student_address, student_phone) values (?, ?, ?, ?, ?, ?, ?)");        

            pstmt.setString(1, newStudentObj.getName());

            pstmt.setString(2, newStudentObj.getEmail());

            pstmt.setString(3, newStudentObj.getDate());

            pstmt.setString(4, newStudentObj.getGender());
            
            pstmt.setString(5, newStudentObj.getLop());

            pstmt.setString(6, newStudentObj.getAddress());
            
            pstmt.setString(7, newStudentObj.getPhone());

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

                editRecord.setDate(resultSetObj.getString("student_date"));
                
                editRecord.setLop(resultSetObj.getString("student_class"));
                
                editRecord.setPhone(resultSetObj.getString("student_phone"));

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

            pstmt = getConnection().prepareStatement("update student_record set student_name=?, student_email=?, student_date=?, student_gender=?, student_class=?, student_address=?, student_phone=? where student_id=?");   

            pstmt.setString(1,updateStudentObj.getName()); 

            pstmt.setString(2,updateStudentObj.getEmail()); 

            pstmt.setString(3,updateStudentObj.getDate()); 

            pstmt.setString(4,updateStudentObj.getGender());
            
            pstmt.setString(5,updateStudentObj.getLop());

            pstmt.setString(6,updateStudentObj.getAddress());
            
            pstmt.setString(7,updateStudentObj.getPhone());

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
				u.setEmail(rs.getString("student_email"));
				u.setGender(rs.getString("student_gender"));
				u.setAddress(rs.getString("student_address"));
				u.setDate(rs.getString("student_date"));
				u.setLop(rs.getString("student_class"));
				u.setPhone(rs.getString("student_phone")); 
				
				list.add(u);
			}
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
