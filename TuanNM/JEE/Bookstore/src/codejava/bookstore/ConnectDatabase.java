package codejava.bookstore;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConnectDatabase {
	private Connection jdbcConnection;
	

	public static Connection getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
		Connection conn = null;
		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = (Connection) driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public boolean insertBook(Book book) {
		boolean rowInserted = false ;
		String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
		try {
			PreparedStatement statement = (PreparedStatement) jdbcConnection.prepareStatement(sql);
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setFloat(3, book.getPrice());
			rowInserted = statement.executeUpdate() > 0;
	        statement.close();   
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowInserted;
		
	}
	public ArrayList<Book> listAllBooks() throws SQLException {
        ArrayList<Book> listBook = new ArrayList<>();
         
        String sql = "SELECT * FROM book";
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
             
            Book book = new Book(id, title, author, price);
            listBook.add(book);
        }
         
        resultSet.close();
        statement.close();
         

         
        return listBook;
    }
     
    public boolean deleteBook(Book book) throws SQLException {
        String sql = "DELETE FROM book where book_id = ?";
         

         
        PreparedStatement statement = (PreparedStatement) jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
  
        return rowDeleted;     
    }
     
    public boolean updateBook(Book book) throws SQLException {
        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
        sql += " WHERE book_id = ?";

         
        PreparedStatement statement = (PreparedStatement) jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setFloat(3, book.getPrice());
        statement.setInt(4, book.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        return rowUpdated;     
    }
     
    public Book getBook(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM book WHERE book_id = ?";
        PreparedStatement statement = (PreparedStatement) jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);      
        ResultSet resultSet = statement.executeQuery();        
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
             
            book = new Book(id, title, author, price);
        }
         
        resultSet.close();
        statement.close();
         
        return book;
    }
}