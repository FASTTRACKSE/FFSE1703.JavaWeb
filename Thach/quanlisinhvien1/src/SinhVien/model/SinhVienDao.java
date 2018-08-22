package SinhVien.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class SinhVienDao {
		Connection conn = (Connection) ConnectDb.getConnect();
		public boolean addSv(SinhVien Sv) throws SQLException {
		    String sql = "INSERT INTO quanlysinhvien (ma_sv, ten, ngaysinh, quequan, gioitinh, lop, lp1, lp2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		    
		    PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
		    stm.setString(1, Sv.getMasv());
		    stm.setString(2, Sv.getTen());
		    stm.setString(3, Sv.getNgaysinh());
		    stm.setString(4, Sv.getQuequan());
		    stm.setString(5, Sv.getGioitinh());
		    stm.setString(6, Sv.getLop());
		    stm.setFloat(7, Sv.getLp1());
		    stm.setFloat(8, Sv.getLp2());
			
		    boolean rowInserted = stm.executeUpdate() > 0;
		    stm.close();
		    return rowInserted;
			}
		
		public List<SinhVien> listAllSinhVien(int start, int maxItem) throws SQLException {
		    List<SinhVien> listSinhVien = new ArrayList<>();
		     
		    String sql = "SELECT * FROM quanlysinhvien limit ?,?";
		     
		     
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		    ps.setInt(1, start);
		    ps.setInt(2, maxItem);
		    ResultSet resultSet = ps.executeQuery();
		     
		    while (resultSet.next()) {
		        int id = resultSet.getInt("id");
		        String masv = resultSet.getString("ma_sv");
		        String ten = resultSet.getString("ten");
		        String ngaysinh = resultSet.getString("ngaysinh");
		        String quequan = resultSet.getString("quequan");
		        String gioitinh = resultSet.getString("gioitinh");
		        String lop = resultSet.getString("lop");
		        float lp1 = resultSet.getFloat("lp1");
		        float lp2 = resultSet.getFloat("lp2");
		         
		        SinhVien Sv = new SinhVien(id, masv, ten, ngaysinh, quequan, gioitinh, lop, lp1, lp2);
		        listSinhVien.add(Sv);
		    }
		     
		    resultSet.close();
		    ps.close();
		    return listSinhVien;
		}
		 
		public boolean deleteSv(SinhVien Sv) throws SQLException {
		    String sql = "DELETE FROM quanlysinhvien where id = ?";
		    PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
		    stm.setInt(1, Sv.getId());
		    
		    boolean rowDeleted = stm.executeUpdate() > 0;
		    stm.close();
		    return rowDeleted;     
		}
		 
		public boolean updateSt(int id, SinhVien Sv) throws SQLException {
		    String sql = "UPDATE quanlysinhvien SET ma_sv = ?, ten = ?, ngaysinh = ?, quequan = ?, gioitinh = ?, lop = ?, lp1 = ?, lp2 = ?";
		    sql += " WHERE id = ?";
		     
		    PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
		    stm.setString(1, Sv.getMasv());
		    stm.setString(2, Sv.getTen());
		    stm.setString(3, Sv.getNgaysinh());
		    stm.setString(4, Sv.getQuequan());
		    stm.setString(5, Sv.getGioitinh());
		    stm.setString(6, Sv.getLop());
		    stm.setFloat(7, Sv.getLp1());
		    stm.setFloat(8, Sv.getLp2());
		    stm.setFloat(9, id);
		     
		    boolean rowUpdated = stm.executeUpdate() > 0;
		    stm.close();
		    return rowUpdated;     
		}
		 
		public SinhVien getSv(int id) throws SQLException {
		    SinhVien Sv = null;
		    String sql = "SELECT * FROM quanlysinhvien WHERE id = ?";
		     
		    PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
		    stm.setInt(1, id);
		     
		    ResultSet resultSet = stm.executeQuery();
		     
		    if (resultSet.next()) {
		        String masv = resultSet.getString("ma_sv");
		        String ten = resultSet.getString("ten");
		        String ngaysinh = resultSet.getString("ngaysinh");
		        String quequan = resultSet.getString("quequan");
		        String gioitinh = resultSet.getString("gioitinh");
		        String lop = resultSet.getString("lop");
		        float lp1 = resultSet.getFloat("lp1");
		        float lp2 = resultSet.getFloat("lp2");
		        Sv = new SinhVien(id, masv, ten, ngaysinh, quequan, gioitinh, lop, lp1, lp2);
		    }
		     
		    resultSet.close();
		    stm.close();
		     
		    return Sv;
		}
		public int countAll() throws SQLException {
			String sql = "select count(*) from quanlysinhvien";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt("count(*)");
			}
			rs.close();
			st.close();
			return 0;
		}
}
