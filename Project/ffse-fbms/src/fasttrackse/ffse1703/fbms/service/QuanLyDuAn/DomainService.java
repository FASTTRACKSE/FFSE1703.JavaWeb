package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;


import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Domain;

public interface DomainService {
	
	public List<Domain> getAll();

	public Domain findById(String maNghiepVu);

	public void add(Domain domain);

	public void update( Domain domain);

	public void delete(Domain domain);

	public List<Domain> findAllForPaging(int startPosition, int maxResult);

}
