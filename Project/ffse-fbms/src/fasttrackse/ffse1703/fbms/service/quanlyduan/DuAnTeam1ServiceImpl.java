package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.DuAnTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.DuAnTeam1;

@Service
public class DuAnTeam1ServiceImpl implements DuAnTeam1Service {
	@Autowired
	DuAnTeam1Dao duAnTeam1Dao;

	@Override
	@Transactional
	public List<DuAnTeam1> getAll() {
		return this.duAnTeam1Dao.getAll();
	}
	@Transactional
	@Override
	public void delete(String maDuAn) {
		this.duAnTeam1Dao.delete(maDuAn);
		
	}
	@Transactional
	@Override
	public void save(DuAnTeam1 duAn) {
		this.duAnTeam1Dao.save(duAn);
		
	}
	@Transactional
	@Override
	public DuAnTeam1 getById(String maDuAn) {
		return this.duAnTeam1Dao.getById(maDuAn);

	}
	@Transactional
	@Override
	public void update(DuAnTeam1 duAn) {
		this.duAnTeam1Dao.update(duAn);
		
	}
	@Transactional
	@Override
	public void setIsDelete(String maDuAn) {
		this.duAnTeam1Dao.setIsDelete(maDuAn);
		
	}
	@Transactional
	@Override
	public int getName(String tenDuAn) {
		return this.duAnTeam1Dao.getName(tenDuAn);

	}

}
