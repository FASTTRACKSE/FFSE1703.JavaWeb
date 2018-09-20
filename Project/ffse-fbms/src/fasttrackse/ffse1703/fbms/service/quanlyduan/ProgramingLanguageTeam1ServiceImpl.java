package fasttrackse.ffse1703.fbms.service.quanlyduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlyduan.ProgramingLanguageTeam1Dao;
import fasttrackse.ffse1703.fbms.entity.quanlyduan.ProgramingLanguageTeam1;

@Service
public class ProgramingLanguageTeam1ServiceImpl implements ProgramingLanguageTeam1Service {
	@Autowired
	private ProgramingLanguageTeam1Dao languageDao;

	@Override
	@Transactional
	public List<ProgramingLanguageTeam1> getAll() {
		// TODO Auto-generated method stub
		return this.languageDao.getAll();
	}

	@Override
	public void delete(String maNn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNew(ProgramingLanguageTeam1 Nn) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProgramingLanguageTeam1 getById(String maNn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ProgramingLanguageTeam1 Nn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIsDelete(String maNn) {
		// TODO Auto-generated method stub

	}

}
