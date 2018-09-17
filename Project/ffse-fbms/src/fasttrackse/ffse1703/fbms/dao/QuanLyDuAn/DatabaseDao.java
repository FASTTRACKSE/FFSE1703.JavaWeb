package fasttrackse.ffse1703.fbms.dao.QuanLyDuAn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Database;

public interface DatabaseDao {
	public List<Database> getAll();
	public void delete(String maDatabase);
	public void save(Database database);
	public Database getById(String maDatabase);
	public void update(Database database);
	public void setIsDelete(String maDatabase);



}
