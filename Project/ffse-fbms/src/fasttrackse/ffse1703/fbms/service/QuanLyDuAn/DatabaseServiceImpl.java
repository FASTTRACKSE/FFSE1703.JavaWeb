package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.QuanLyDuAn.DatabaseDao;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Database;

@Service
public class DatabaseServiceImpl implements DatabaseService {
	@Autowired
	DatabaseDao databaseDao;

	@Override
	@Transactional
	public List<Database> getAll() {
		return this.databaseDao.getAll();
	}

	@Override
	@Transactional
	public void delete(String maDatabase) {
		this.databaseDao.delete(maDatabase);

	}

	@Transactional
	@Override
	public void save(Database database) {
		this.databaseDao.save(database);

	}

	@Transactional
	@Override
	public Database getById(String maDatabase) {
		return this.databaseDao.getById(maDatabase);
	}

	@Transactional
	@Override
	public void update(Database database) {
		this.databaseDao.update(database);

	}

	@Transactional
	@Override
	public void setIsDelete(String maDatabase) {
		this.databaseDao.setIsDelete(maDatabase);

	}

	@Transactional
	@Override
	public int getName(String tenDatabase) {
		return this.databaseDao.getName(tenDatabase);
	}


}
