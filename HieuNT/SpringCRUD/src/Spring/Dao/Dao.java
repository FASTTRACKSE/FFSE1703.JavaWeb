package Spring.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Spring.entity.Emp;

public class Dao {
	static JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		Dao.template = template;
	}

	public static int save(Emp p,String filename) {
		String sql = "insert into CRUD(name,address,email,nameFile) " + "values " + "('" + p.getName() + "','" + p.getAddress()
				+ "','" + p.getEmail() + "','" + filename + "')";
		return template.update(sql);
	}

	public int update(Emp p) {
		String sql = "update CRUD set name='" + p.getName() + "', address='" + p.getAddress() + "',email='"
				+ p.getEmail()+ "',nameFile='"
						+ p.getNameFile()+ "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from CRUD where id=" + id + "";
		return template.update(sql);
	}

	public Emp getEmpById(int id) {
		String sql = "select * from CRUD where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public List<Emp> getEmployeesByPage(int pageid, int total) {
		String sql = "select * from CRUD limit " + pageid+ "," + total;
		return template.query(sql, new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setNameFile(rs.getString(5));
				return e;
			}
		});

		/*
		 * return template.query("select * from CRUD", new RowMapper<Emp>() { public Emp
		 * mapRow(ResultSet rs, int row) throws SQLException { Emp e = new Emp();
		 * e.setId(rs.getInt(1)); e.setName(rs.getString(2));
		 * e.setAddress(rs.getString(3)); e.setEmail(rs.getString(4)); return e; } });
		 */
	}
	public int countSV() {
		String sql="select count(*) from CRUD ";
		return template.queryForObject(sql, Integer.class);
	}

}
