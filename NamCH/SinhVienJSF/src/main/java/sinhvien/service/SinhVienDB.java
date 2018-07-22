package sinhvien.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sinhvien.bean.ControllerBean;

public class SinhVienDB {
	static ConnectDB myDB = new ConnectDB();
	private static Connection conn= myDB.getConnect("localhost", "sinhvienjsf", "hainam", "123456");
	static ArrayList<SinhVien> arrStd = new ArrayList<SinhVien>();
	public static int addStudent(SinhVien std) {
		try {
			String sql = "insert into sinhvien (name, year, sex, email,"
					+ "phone,adress,classes) "
					+ " values (?, ?, ?, ?, ?,?,?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, std.getName());
			stm.setInt(2, std.getYear());
			stm.setString(3, std.getSex());
			stm.setString(4, std.getEmail());;
			stm.setString(5, std.getPhone());
			stm.setString(6, std.getAdress());
			stm.setString(7, std.getClasses());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<SinhVien> getStudentList() {
		ArrayList<SinhVien> arrStd = new ArrayList<SinhVien>();
		try {
			String sql = "SELECT * " + 
					"FROM sinhvien ORDER by id DESC "; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				SinhVien std = new SinhVien();
				std.setId(rs.getInt("id"));
				std.setName(rs.getString("name"));
				std.setYear(rs.getInt("year"));
				std.setSex(rs.getString("sex"));
				std.setEmail(rs.getString("email"));
				std.setPhone(rs.getString("phone"));	
				std.setAdress(rs.getString("adress"));
				std.setClasses(rs.getString("classes"));
				arrStd.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(arrStd);
		return arrStd;
		
	}
	
	public static int delStudent(int id) {
		try {
			String sql = "DELETE FROM sinhvien where id = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, id);				
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static SinhVien searchCode(int id) {
		SinhVien std = new SinhVien();
		try {
			
			String sql = "SELECT * FROM sinhvien WHERE id = ? ORDER BY id DESC ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				
				std.setId(rs.getInt("id"));
				std.setName(rs.getString("name"));
				std.setYear(rs.getInt("year"));
				std.setSex(rs.getString("sex"));
				std.setEmail(rs.getString("email"));
				std.setPhone(rs.getString("phone"));	
				std.setAdress(rs.getString("adress"));
				std.setClasses(rs.getString("classes"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return std;
	}
	
	public static int updateStudent(SinhVien std) {
		try {
			String sql = "update sinhvien set name = ?, year = ?, sex = ?, "
					+ "email = ?,phone = ?,adress= ?,classes = ? where id = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, std.getName());
			stm.setInt(2, std.getYear());
			stm.setString(3, std.getSex());
			stm.setString(4, std.getEmail());;
			stm.setString(5, std.getPhone());
			stm.setString(6, std.getAdress());
			stm.setString(7, std.getClasses());	
			stm.setInt(8, std.getId());	
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int countStudent() {
		int count=-1;
		try {
			String sql = "SELECT COUNT(*) AS total FROM sinhvien"; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				count=rs.getInt("total");
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static ArrayList<SinhVien> sinhVienList(int start, int end){
		arrStd.clear();
		try {
		String sql = "select * from sinhvien limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			SinhVien std = new SinhVien();
			std.setId(rs.getInt("id"));
			std.setName(rs.getString("name"));
			std.setYear(rs.getInt("year"));
			std.setSex(rs.getString("sex"));
			std.setEmail(rs.getString("email"));
			std.setPhone(rs.getString("phone"));	
			std.setAdress(rs.getString("adress"));
			std.setClasses(rs.getString("classes"));
			arrStd.add(std);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrStd;
	}
	public static int checkName(String name) {
		int check=0;
		try {
			String sql = "SELECT COUNT(*) AS total FROM sinhvien where name like '"+"%"+name+"%"+"'"; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				check=rs.getInt("total");
			}
			return check;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
}
