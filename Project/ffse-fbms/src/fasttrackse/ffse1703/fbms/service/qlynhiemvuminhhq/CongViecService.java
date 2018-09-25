package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;




 public interface CongViecService {
 	public List<CongViecMinhHQ> findAll();

 	public void addNew(CongViecMinhHQ cv);

 	public void update(CongViecMinhHQ cv);

 	public void delete(CongViecMinhHQ cv);

 	public CongViecMinhHQ findByID(int ID);
	
 	public List<CongViecMinhHQ> findAll(int iDisplayStart, int iDisplayLength, String sql);
 	
 	public List<TrangThaiMinhHQ> trangThai();
 	
 	public List<LoaiCongViecMinhHQ> loaiCongViec();
// 	public String getRecordsTotal();
//	
// 	public String getRecordsFiltered(String sql);
//	
	
 }
