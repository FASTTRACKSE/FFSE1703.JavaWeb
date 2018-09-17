package fasttrackse.ffse1703.fbms.dao.qlynhiemvuhieulp;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;

public interface QLyNhiemVuDao {
	public List<QLyNhiemVuEntity> findAll();

	public void addNew(QLyNhiemVuEntity nv);

	public void update(QLyNhiemVuEntity nv);

	public void delete(int ID);

	public QLyNhiemVuEntity findByTenCongViec(int ID);
	
	public List<QLyNhiemVuEntity> findAll(int iDisplayStart, int iDisplayLength, String sql);
	
	public String getRecordsTotal();
	
	public String getRecordsFiltered(String sql);
}
