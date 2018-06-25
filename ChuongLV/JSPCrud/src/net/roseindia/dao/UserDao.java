package net.roseindia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import net.roseindia.bean.UserBean;
import net.roseindia.dbconnection.ConnectionProvider;

public class UserDao {

    private Connection conn;

    public UserDao() {
    	conn = ConnectionProvider.getConnection();
    }

    public void addUser(UserBean userBean) {
        try {
        	String sql = "INSERT INTO user(userid, firstname, lastname, date, country, gender, class)" +
    		" VALUES (?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(sql);   
            ps.setInt(1, userBean.getId());
            ps.setString(2, userBean.getfName());
            ps.setString(3, userBean.getlName());
            ps.setString(4, userBean.getdate());
            ps.setString(5, userBean.getcountry());
            ps.setString(6, userBean.getgender());
            ps.setString(7, userBean.getclass());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int userId) {
        try {
        	String sql = "DELETE FROM user WHERE userid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editUser(UserBean userBean) {    	
    	try {
    		String sql = "UPDATE user SET firstname=?, lastname=?, date=?, country=?, gender=?, class=?" +
            " WHERE userid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, userBean.getId());
            ps.setString(2, userBean.getfName());
            ps.setString(3, userBean.getlName());           
            ps.setString(4, userBean.getdate());
            ps.setString(5, userBean.getcountry());
            ps.setString(6, userBean.getgender());
            ps.setString(7, userBean.getclass());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List getAllUsers() {
        List users = new ArrayList();
        try {
        	String sql = "SELECT * FROM user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBean userBean = new UserBean();
                userBean.setId(rs.getInt("userid"));
                userBean.setfName(rs.getString("firstname"));
                userBean.setlName(rs.getString("lastname"));
                userBean.setdate(rs.getString("date"));
                userBean.setcountry(rs.getString("country"));
                userBean.setgender(rs.getString("gender"));
                userBean.setClass(rs.getString("class"));    
                users.add(userBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public UserBean getUserById(int userId) {
    	UserBean userBean = new UserBean();
        try {
        	String sql = "SELECT * FROM user WHERE userid=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	userBean.setId(rs.getInt("userid"));
            	userBean.setfName(rs.getString("firstname"));
            	userBean.setlName(rs.getString("lastname"));
            	userBean.setdate(rs.getString("date"));
            	userBean.setcountry(rs.getString("country"));
            	userBean.setgender(rs.getString("gender"));
            	userBean.setClass(rs.getString("class"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;
    }
}