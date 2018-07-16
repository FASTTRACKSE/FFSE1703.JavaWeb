package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private Connection conn = ConnectDB.getConnect();
	private PreparedStatement ps;
	private String sql;

	public int addSV(Student sv) throws SQLException {
		sql = "INSERT INTO SinhVien( HoDem,Tensv,Tuoi,Sex,QueQuan,Lop,LP1,LP2) VALUES (?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		

		ps.setString(1, sv.getFirstName());
		ps.setString(2, sv.gettxtName());
		ps.setString(3, sv.gettxtDate());
		ps.setString(4, sv.gettxtSex());
		ps.setString(5, sv.getQueQuan());
		ps.setString(6, sv.gettxtLop());
		ps.setString(7, String.valueOf(sv.getLp1()));
		ps.setString(8, String.valueOf(sv.getLp2()));


		return ps.executeUpdate();
	}

	public int repCus(Student sv) throws SQLException {
		sql = "UPDATE SinhVien SET HoDem=?,Tensv=?,Tuoi=?,Sex=?,QueQuan=?,Lop=?,LP1=?,LP2=? WHERE ID=?";
		ps =  conn.prepareStatement(sql);
		ps.setString(1, sv.getFirstName());
		ps.setString(2, sv.gettxtName());
		ps.setString(3, sv.gettxtDate());
		ps.setString(4, sv.gettxtSex());
		ps.setString(5, sv.getQueQuan());
		ps.setString(6, sv.gettxtLop());
		ps.setString(7, String.valueOf(sv.getLp1()));
		ps.setString(8, String.valueOf(sv.getLp2()));		
		ps.setInt(9, sv.getId());;
		
		return ps.executeUpdate();
	}

	public int delCus(int id) throws SQLException {
		sql = "DELETE FROM SinhVien WHERE ID=?";
		ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, id);

		return ps.executeUpdate();
	}

	public List<Student> listAllStudent() {
		List<Student> listStudent = new ArrayList<>();

		try {
			sql = "SELECT * FROM SinhVien";

			ps = conn.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String sex = resultSet.getString("Sex");
				String hoDem = resultSet.getString("HoDem");
				String tenSV = resultSet.getString("Tensv");
				String que = resultSet.getString("QueQuan");
				String age = resultSet.getString("Tuoi");
				String lop = resultSet.getString("Lop");
				float lp1=resultSet.getFloat("LP1");
				float lp2=resultSet.getFloat("LP2");
				Student sv = new Student(id, hoDem, tenSV, age, sex, que, lop,lp1,lp2);
				listStudent.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStudent;
	}
	public List<Student> listStudentPage(int start, int total) {
		List<Student> listStudent = new ArrayList<>();

		try {
			sql = "SELECT * FROM SinhVien Limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start-1);
			ps.setInt(2, total);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String sex = resultSet.getString("Sex");
				String hoDem = resultSet.getString("HoDem");
				String tenSV = resultSet.getString("Tensv");
				String que = resultSet.getString("QueQuan");
				String age = resultSet.getString("Tuoi");
				String lop = resultSet.getString("Lop");
				float lp1=resultSet.getFloat("LP1");
				float lp2=resultSet.getFloat("LP2");
				Student sv = new Student(id, hoDem, tenSV, age, sex, que, lop,lp1,lp2);
				listStudent.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStudent;
	}
	public Student getStuByID(String id) {
		Student sv=null;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from SinhVien where ID=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sv = new Student();
				sv.setFirstName(rs.getString("HoDem"));
				sv.settxtName(rs.getString("Tensv"));
				sv.settxtDate(rs.getString("Tuoi"));
				sv.settxtSex(rs.getString("Sex"));
				sv.setQueQuan(rs.getString("QueQuan"));
				sv.settxtLop(rs.getString("Lop"));
				sv.setLp1(Float.parseFloat(rs.getString("LP1")));
				sv.setLp2(Float.parseFloat(rs.getString("LP2")));

			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return sv;
	}
	public int countRecords() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from SinhVien");
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
