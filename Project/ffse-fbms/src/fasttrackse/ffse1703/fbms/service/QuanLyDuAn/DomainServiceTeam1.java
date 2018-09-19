package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;


import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.DomainTeam1;

public interface DomainServiceTeam1 {
	
	public List<DomainTeam1> getAll();

	public DomainTeam1 findById(String maNghiepVu);

	public void add(DomainTeam1 domainTeam1);

	public void update( DomainTeam1 domainTeam1);

	public void delete(DomainTeam1 domainTeam1);

	public List<DomainTeam1> findAllForPaging(int startPosition, int maxResult);

}
