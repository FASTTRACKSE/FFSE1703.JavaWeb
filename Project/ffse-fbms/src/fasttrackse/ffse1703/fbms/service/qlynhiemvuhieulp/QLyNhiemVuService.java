package fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;



public interface QLyNhiemVuService {
	public List<QLyNhiemVuEntity> findAll();

	public void addNew(QLyNhiemVuEntity nv);

	public void update(QLyNhiemVuEntity nv);

	public void delete(int ID);
	
	public String toJson(QLyNhiemVuEntity nv);

	
	public QLyNhiemVuEntity findByTenCongViec(String tenCongviec);
	
	public List<QLyNhiemVuEntity> findAll(int iDisplayStart, int iDisplayLength, String sql);
	
	public String getRecordsTotal();
	
	public String getRecordsFiltered(String sql);
	
	public String getSQL(HttpServletRequest request);
}
