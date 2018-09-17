package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.TechnicalDAO;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Technical;
@Service
public class TechnicalServiceImpl implements TechnicalService {
	@Autowired
	private TechnicalDAO technicalDAO;
	

	public void setTechnicalDAO(TechnicalDAO technicalDAO) {
		this.technicalDAO = technicalDAO;
	}

	@Override
	@Transactional
	public List<Technical> findAll() {
		
		return technicalDAO.findAll();
	}

	@Override
	@Transactional
	public Technical findById(int id) {
		
		return technicalDAO.findById(id);
	}

	@Override
	@Transactional
	public void addNew(Technical technical) {
		
		technicalDAO.addNew(technical);
	}

	@Override
	@Transactional
	public void update(Technical technical) {
		technicalDAO.update(technical);
		
	}

	@Override
	@Transactional
	public void delete(Technical technical) {
	technicalDAO.delete(technical);
		
	}

	@Override
	@Transactional
	public int checkDomain(String name) {
		return technicalDAO.checkDomain(name);
	}

}
