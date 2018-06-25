package quanlisinhvien;

import java.awt.print.Book;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SinhVienDao {
	    	Connection conn = (Connection) connectDb.getConnect();
	    	public boolean addSinhVien(SinhVien Sv) throws SQLException {
	        String sql = "INSERT INTO quanlysinhvien (ma_sv, name, class, lp1, lp2) VALUES (?, ?, ?, ?, ?)";
	        
	        PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
	        stm.setString(1, Sv.getMasv());
	        stm.setString(2, Sv.getName());
	        stm.setString(3, Sv.getClasse());
	        stm.setFloat(4, Sv.getLp1());
	        stm.setFloat(5, Sv.getLp2());
	    	
	        boolean rowInserted = stm.executeUpdate() > 0;
	        stm.close();
	        return rowInserted;
	    	}
	
	    public List<SinhVien> listAllSinhVien() throws SQLException {
	        List<SinhVien> listSinhVien = new ArrayList<>();
	         
	        String sql = "SELECT * FROM quanlysinhvien";
	         
	         
	        Statement statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String masv = resultSet.getString("masv");
	            String name = resultSet.getString("name");
	            String classe = resultSet.getString("class");
	            float lp1 = resultSet.getFloat("lp1");
	            float lp2 = resultSet.getFloat("lp2");
	             
	            SinhVien Sv = new SinhVien(id, masv, name, classe, classe, lp1, lp2);
	            listSinhVien.add(Sv);
	        }
	         
	        resultSet.close();
	        statement.close();
	         
	        return listSinhVien;
	    }
	     
//	    public boolean deleteBook(Book book) throws SQLException {
//	        String sql = "DELETE FROM book where book_id = ?";
//	         
//	        connect();
//	         
//	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//	        statement.setInt(1, book.getId());
//	         
//	        boolean rowDeleted = statement.executeUpdate() > 0;
//	        statement.close();
//	        return rowDeleted;     
//	    }
	     
//	    public boolean updateBook(Book book) throws SQLException {
//	        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
//	        sql += " WHERE book_id = ?";
//	         
//	        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//	        statement.setString(1, book.getTitle());
//	        statement.setString(2, book.getAuthor());
//	        statement.setFloat(3, book.getPrice());
//	        statement.setInt(4, book.getId());
//	         
//	        boolean rowUpdated = statement.executeUpdate() > 0;
//	        statement.close();
//	        return rowUpdated;     
//	    }
	     
	    public SinhVien getSinhVien(int id) throws SQLException {
	        SinhVien Sv = null;
	        String sql = "SELECT * FROM quanlysinhvien WHERE id = ?";
	         
	        PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
	        stm.setInt(1, id);
	         
	        ResultSet resultSet = stm.executeQuery();
	         
	        if (resultSet.next()) {
	            String masv = resultSet.getString("masv");
	            String name = resultSet.getString("name");
	            String classe = resultSet.getString("class");
	            float lp1 = resultSet.getFloat("lp1");
	            float lp2 = resultSet.getFloat("lp2");
	            Sv = new SinhVien(id, masv, name, classe, classe, lp1, lp2);
	        }
	         
	        resultSet.close();
	        stm.close();
	         
	        return Sv;
	    }
	}

