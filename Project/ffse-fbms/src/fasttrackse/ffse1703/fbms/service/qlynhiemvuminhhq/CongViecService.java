package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViec;




 public interface CongViecService {
 	public List<CongViec> findAll();

 	public void addNew(CongViec cv);

 	public void update(CongViec cv);

 	public void delete(CongViec cv);

 	public CongViec findByID(int ID);
	
 	public List<CongViec> findAll(int iDisplayStart, int iDisplayLength, String sql);
	
// 	public String getRecordsTotal();
//	
// 	public String getRecordsFiltered(String sql);
//	
	
 }
