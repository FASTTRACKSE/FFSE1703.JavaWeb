package fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViec;




 public interface QLyNhiemvuMinhHQDao {
 	public List<CongViec> findAll();

 	public void addNew(CongViec cv);

 	public void update(CongViec cv);

 	public void delete(CongViec cv);

 	public CongViec findByID(int ID);
	
 	public List<CongViec> findAll(int iDisplayStart, int iDisplayLength, String sql);
	
// 	public String getRecordsTotal();
//	
// 	public String getRecordsFiltered(String sql);
 }
