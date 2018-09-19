package fasttrackse.ffse1703.fbms.dao.QuanLyDuAn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Domain;

public interface DomainDao {
	public List<Domain> getAll();

	public Domain findById(String maNghiepVu);

	public void delete(Domain domain);

	public void update(Domain domain);

	public void create(Domain domain);
	
	public List<Domain> findAllForPaging(int startPosition,int maxResult);


}
