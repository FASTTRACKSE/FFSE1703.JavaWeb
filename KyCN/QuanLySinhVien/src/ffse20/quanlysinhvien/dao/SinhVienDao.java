package ffse20.quanlysinhvien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ffse20.quanlysinhvien.connect.*;
import ffse20.quanlysinhvien.model.*;



public class SinhVienDao {
	private Connection conn;
	
    public SinhVienDao() {
    	conn = Connect.getConnection();
    }
    
    public List<SinhVienModel> getAllUsers() {
        List SV = new ArrayList();
        try {
        	String sql = "SELECT * FROM sinhvien_javaweb";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVienModel SVmodel = new SinhVienModel();
                SVmodel.setId(rs.getInt("id"));
                SVmodel.setHoDem(rs.getString("hoDem"));
                SVmodel.setTen(rs.getString("ten"));
                SVmodel.setNgaySinh(rs.getString("ngaySinh")); 
                SVmodel.setQueQuan(rs.getString("queQuan")); 
                SVmodel.setGioiTinh(rs.getString("gioiTinh")); 
                SVmodel.setLop(rs.getString("lop")); 
                SV.add(SVmodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return SV;
    }

	public void addUser(SinhVienModel user) {
		// TODO Auto-generated method stub
        try {
        	String sql = "INSERT INTO sinhvien_javaweb(id, hoDem,ten,ngaySinh,queQuan,gioiTinh,lop)" +
    		" VALUES (?, ?, ?, ? , ? ,? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, user.getId());
            ps.setString(2, user.getHoDem());
            ps.setString(3, user.getTen());
            ps.setString(4, user.getNgaySinh());
            ps.setString(5, user.getQueQuan());
            ps.setString(6, user.getGioiTinh()); 
            ps.setString(7, user.getLop());             
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public void removeUser(int userId) {
		// TODO Auto-generated method stub
        try {
        	String sql = "DELETE FROM sinhvien_javaweb WHERE id=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

    public void editUser(SinhVienModel userBean) {    	
    	try {
    		String sql = "UPDATE sinhvien_javaweb SET hoDem=?, ten=? ,ngaySinh=? ,queQuan=? ,gioiTinh=? ,lop=?" +
            " WHERE id=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, userBean.getId());
            ps.setString(2, userBean.getHoDem());
            ps.setString(3, userBean.getTen());
            ps.setString(4, userBean.getNgaySinh());
            ps.setString(5, userBean.getQueQuan());
            ps.setString(6, userBean.getGioiTinh()); 
            ps.setString(7, userBean.getLop()); 
            
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public SinhVienModel getUserById(int userId) {
    	SinhVienModel userBean = new SinhVienModel();
        try {
        	String sql = "SELECT * FROM sinhvien_javaweb WHERE id=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	userBean.setId(rs.getInt("id"));
            	userBean.setHoDem(rs.getString("hoDem"));
            	userBean.setTen(rs.getString("ten"));
            	userBean.setNgaySinh(rs.getString("ngaySinh")); 
            	userBean.setQueQuan(rs.getString("queQuan")); 
            	userBean.setGioiTinh(rs.getString("gioiTinh")); 
            	userBean.setLop(rs.getString("lop"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;
    }
    
}
