package fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.*;




 public interface QLyNhiemvuMinhHQDao {
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
 }
