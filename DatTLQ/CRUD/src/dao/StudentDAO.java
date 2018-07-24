package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import model.Model;

public class StudentDAO {
	private static Connection conn = ConnectDB.getConnect();
	private static PreparedStatement ps;
	private static String sql;

	public static String addSV(Model sv) throws SQLException {
		String redirect="";
		sql = "INSERT INTO Student( Hodem,Ten,Namsinh,Sex,Email,SDT,Diachi,Lop) VALUES (?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		

		ps.setString(1, sv.getFirstName());
		ps.setString(2, sv.getTxtName());
		ps.setString(3, sv.getTxtDate());
		ps.setString(4, sv.getTxtSex());
		ps.setString(5, sv.getEmail());
		ps.setString(6, sv.getSdt());
		ps.setString(7, sv.getDiaChi());
		ps.setString(8, sv.getTxtLop());
		boolean rowInserted=ps.executeUpdate()>0;
		if(rowInserted == true) {
			redirect= "index.xhtml?faces-redirect=true";
		}else {
			redirect="insert.xhtml?faces-redirect=true";
		}
	return redirect;	
	}

	public static String repCus(Model sv) throws SQLException {
		String redirect="";

		sql = "UPDATE Student SET Hodem=?,Ten=?,Namsinh=?,Sex=?,Email=?,SDT=?,Diachi=?,Lop=? WHERE ID=?";
		ps =  conn.prepareStatement(sql);
		ps.setString(1, sv.getFirstName());
		ps.setString(2, sv.getTxtName());
		ps.setString(3, sv.getTxtDate());
		ps.setString(4, sv.getTxtSex());
		ps.setString(5, sv.getEmail());
		ps.setString(6, sv.getSdt());
		ps.setString(7, sv.getDiaChi());
		ps.setString(8, sv.getTxtLop());		
		ps.setInt(9, sv.getId());;
		
		boolean rowInserted=ps.executeUpdate()>0;
		if(rowInserted == true) {
			redirect= "index.xhtml?faces-redirect=true";
		}else {
			redirect="update.xhtml?faces-redirect=true";
		}
	return redirect;
	}

	public static String delCus(int id) throws SQLException {
		
		sql = "DELETE FROM Student WHERE ID=?";
		ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, id);

		ps.executeUpdate();
		
	return "index.xhtml?faces-redirect=true";
	}

	public static ArrayList<Model> listAllStudent() {
		ArrayList<Model> listStudent = new ArrayList<>();

		try {
			sql = "SELECT * FROM Student";

			ps = conn.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String sex = resultSet.getString("Sex");
				String hoDem = resultSet.getString("Hodem");
				String tenSV = resultSet.getString("Ten");
				String diaChi = resultSet.getString("Diachi");
				String age = resultSet.getString("Namsinh");
				String lop = resultSet.getString("Lop");
				String email=resultSet.getString("Email");
				String sdt=resultSet.getString("SDT");
				Model sv = new Model(id, hoDem, tenSV, age, sex, email, sdt,diaChi,lop);
				listStudent.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStudent;
	}
	public static List<Model> listStudentPage(int start, int total) {
		List<Model> listStudent = new ArrayList<>();

		try {
			sql = "SELECT * FROM Student Limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, total);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String sex = resultSet.getString("Sex");
				String hoDem = resultSet.getString("Hodem");
				String tenSV = resultSet.getString("Ten");
				String diaChi = resultSet.getString("Diachi");
				String age = resultSet.getString("Namsinh");
				String lop = resultSet.getString("Lop");
				String email=resultSet.getString("Email");
				String sdt=resultSet.getString("SDT");
				Model sv = new Model(id, hoDem, tenSV, age, sex, email, sdt,diaChi,lop);
				listStudent.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStudent;
	}
	public static String getStuByID(int id) {
		Model sv=null;
		Map<String, Object> sessionMapObj= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from Student where ID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sv = new Model();
				sv.setId(rs.getInt("ID"));
				sv.setFirstName(rs.getString("Hodem"));
				sv.setTxtName(rs.getString("Ten"));
				sv.setTxtDate(rs.getString("Namsinh"));
				sv.setTxtSex(rs.getString("Sex"));
				sv.setEmail(rs.getString("Email"));
				sv.setSdt(rs.getString("SDT"));
				sv.setDiaChi(rs.getString("Diachi"));
				sv.setTxtLop(rs.getString("Lop"));
				
				sessionMapObj.put("model",sv);

			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return "update.xhtml?faces-redirect=true";
	}
	public static int countRecords() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from Student");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			return count;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
