package model;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class DAO {

	 
    public List<SinhVien> listAllSinhVien() throws SQLException {
        List<Book> listBook = new ArrayList<>();
         
        String sql = "SELECT * FROM SV";
         
        connect();
         
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
         
        disconnect();
         
        return listBook;
    }
     
}
