package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.QuanLyDuAn.DomainDao;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Domain;

@Service
public class DomainServiceImpl implements DomainService{
	@Autowired
	DomainDao domainDao;

	public void setDomainDao(DomainDao domainDao) {
		this.domainDao = domainDao;

	}

	@Override
	@Transactional
	public List<Domain>getAll() {
		return this.domainDao.getAll();
	}

	@Override
	@Transactional
	public Domain findById(String maNghiepVu) {
		return this.domainDao.findById(maNghiepVu) ;
	}

	@Override
	@Transactional
	public void add(Domain domain) {
		this.domainDao.create(domain);
	}

	@Override
	@Transactional
	public void update(Domain domain) {
		this.domainDao.update(domain);

	}

	@Override
	@Transactional
	public void delete(Domain domain) {
		this.domainDao.delete(domain);

	}

	@Override
	@Transactional
	public List<Domain> findAllForPaging(int startPosition, int maxResult) {
		return this.domainDao.findAllForPaging(startPosition, maxResult);
	}

	

}
