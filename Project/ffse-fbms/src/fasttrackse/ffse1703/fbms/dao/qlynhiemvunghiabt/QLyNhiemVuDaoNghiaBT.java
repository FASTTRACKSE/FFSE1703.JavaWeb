package fasttrackse.ffse1703.fbms.dao.qlynhiemvunghiabt;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvunghiabt.*;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;




 public interface QLyNhiemVuDaoNghiaBT {
 	public List<NhiemVu> findAll();

 	public void addNew(NhiemVu cv);

 	public void update(NhiemVu cv);

 	public void delete(NhiemVu cv);

 	public NhiemVu findByID(int ID);
	
 	public List<NhiemVu> findAll(int iDisplayStart, int iDisplayLength, String sql);
 	
 	public List<TrangThaiNghiaBT> trangThai();
 	
 	public List<LoaiCongViecNghiaBT> loaiCongViec();
 	
 	public List<DuAnNghiaBT> duAn();
 	
 	public List<HoSoNhanVien> nhanVien();
 	
 	//public List<NhiemVu> findAllForPaging(int startPosition, int maxResult);
	

 }