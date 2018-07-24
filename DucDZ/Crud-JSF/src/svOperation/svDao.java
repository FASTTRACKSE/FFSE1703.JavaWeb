package svOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.component.behavior.FacesBehavior;
import javax.faces.context.FacesContext;

import svModel.SinhVienBean;
import svOperation.ConnectDB;;

public class svDao {
	public static Connection conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
	public static ArrayList<SinhVienBean> getSVListFromDB(int start,int totals) {
		ArrayList<SinhVienBean> svList = new ArrayList<SinhVienBean>();
		Statement stm;
		ResultSet rs;
		try {
			if (conn.isClosed()) {
				conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
			}
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from jsf_sinh_vien");
			while(rs.next()) {
				SinhVienBean newSV = new SinhVienBean();
				newSV.setId(rs.getInt("id"));
				newSV.setName(rs.getString("ten"));
				newSV.setEmail(rs.getString("email"));
				newSV.setPassword(rs.getString("password"));
				newSV.setGender(rs.getString("gender"));
				newSV.setAddress(rs.getString("address"));
				svList.add(newSV);
			}
			conn.close();
			System.out.println("Tong So Sinh Vien "+svList.size());
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return svList;
	}

	public static String saveSVDetailsInDB(SinhVienBean newSV) throws SQLException {
		int saveResuilt = 0;
		String navResuilt = "";
		if (conn.isClosed()) {
			conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
		}
		PreparedStatement pstm = conn.prepareStatement("insert into jsf_sinh_vien (id,ten,email,password,gender,address) values(?,?,?,?,?,?)");
		pstm.setInt(1, newSV.getId());
		pstm.setString(2, newSV.getName());
		pstm.setString(3, newSV.getEmail());
		pstm.setString(4, newSV.getPassword());
		pstm.setString(5, newSV.getGender());
		pstm.setString(6, newSV.getAddress());
		saveResuilt = pstm.executeUpdate();
		if(saveResuilt != 0) {
			navResuilt = "listsv.xhtml?faces-redirect=true";
		} else {
			navResuilt = "createsv.xhtml?faces-redirect=true";
		}
		conn.close();
		return navResuilt;
	}
	public static String editSVRecordInDB(int svID){
		Statement stm;
		ResultSet rs;
		SinhVienBean existSV = new SinhVienBean();
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			if (conn.isClosed()) {
				conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
			}
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from jsf_sinh_vien where id="+svID+"");
			rs.next();
			if(rs != null) {
				existSV.setId(rs.getInt("id"));
				existSV.setName(rs.getString("ten"));
				existSV.setEmail(rs.getString("email"));
				existSV.setPassword(rs.getString("password"));
				existSV.setGender(rs.getString("gender"));
				existSV.setAddress(rs.getString("address"));
			}
			conn.close();
			sessionMapObj.put("existSV", existSV);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editsv.xhtml?faces-redirect=true";
	}
	public static String updateSVDetailsInDB(SinhVienBean updateSV) {
		PreparedStatement pstmt ;
		try {
			if (conn.isClosed()) {
				conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
			}
			pstmt = conn.prepareStatement("update jsf_sinh_vien set ten=?, email=?, password=?, gender=?, address=? where id=?");    
			pstmt.setString(1,updateSV.getName());  
			pstmt.setString(2,updateSV.getEmail());  
			pstmt.setString(3,updateSV.getPassword());  
			pstmt.setString(4,updateSV.getGender());  
			pstmt.setString(5,updateSV.getAddress());  
			pstmt.setInt(6,updateSV.getId());  
			pstmt.executeUpdate();
			conn.close();			
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		return "listsv.xhtml?faces-redirect=true";
	}
	public static int countRecords() {
		try {
			if (conn.isClosed()) {
				conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
			}
			PreparedStatement ps = conn.prepareStatement("select count(*) from jsf_sinh_vien");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			return count;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public static String deleteSVRecordInDB(int idSV) throws SQLException {
		if (conn.isClosed()) {
			conn = ConnectDB.getConnect("localhost","java_web_asm","root","");
		}
		PreparedStatement pstm = conn.prepareStatement("delete from jsf_sinh_vien where id = "+idSV+"");
		pstm.executeUpdate();
		conn.close();
		return "listsv.xhtml?faces-redirect=true";
	}

}
