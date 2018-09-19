package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.QuanLyDuAn.DomainDaoTeam1;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.DomainTeam1;

@Service
public class DomainServiceImplTeam1 implements DomainServiceTeam1{
	@Autowired
	DomainDaoTeam1 domainDaoTeam1;

	public void setDomainDao(DomainDaoTeam1 domainDaoTeam1) {
		this.domainDaoTeam1 = domainDaoTeam1;

	}

	@Override
	@Transactional
	public List<DomainTeam1>getAll() {
		return this.domainDaoTeam1.getAll();
	}

	@Override
	@Transactional
	public DomainTeam1 findById(String maNghiepVu) {
		return this.domainDaoTeam1.findById(maNghiepVu) ;
	}

	@Override
	@Transactional
	public void add(DomainTeam1 domainTeam1) {
		this.domainDaoTeam1.create(domainTeam1);
	}

	@Override
	@Transactional
	public void update(DomainTeam1 domainTeam1) {
		this.domainDaoTeam1.update(domainTeam1);

	}

	@Override
	@Transactional
	public void delete(DomainTeam1 domainTeam1) {
		this.domainDaoTeam1.delete(domainTeam1);

	}

	@Override
	@Transactional
	public List<DomainTeam1> findAllForPaging(int startPosition, int maxResult) {
		return this.domainDaoTeam1.findAllForPaging(startPosition, maxResult);
	}

	

}
