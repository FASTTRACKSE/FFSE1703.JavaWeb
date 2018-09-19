package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Database;

public interface DatabaseService {
	public List<Database> getAll();
	public void delete(String maDatabase);
	public void save(Database database);
	public Database getById(String maDatabase);
	public void update(Database database);
	public void setIsDelete(String maDatabase);
	public int getName(String tenDatabase);

}
