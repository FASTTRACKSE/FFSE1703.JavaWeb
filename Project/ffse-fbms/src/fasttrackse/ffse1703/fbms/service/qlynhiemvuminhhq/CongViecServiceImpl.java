package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq.QLyNhiemvuMinhHQDao;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;



@Service
public class CongViecServiceImpl implements CongViecService{



	@Autowired
	private QLyNhiemvuMinhHQDao congViecDao;
	
	@Override
	@Transactional
	public List<CongViecMinhHQ> findAll() {
		return congViecDao.findAll();
	}

	@Override
	public void addNew(CongViecMinhHQ cv) {
		congViecDao.addNew(cv);
	}

	@Override
	public void update(CongViecMinhHQ cv) {
		congViecDao.update(cv);
	}

	@Override
	public void delete(CongViecMinhHQ cv) {
		congViecDao.delete(cv);
	}

	@Override
	public CongViecMinhHQ findByID(int ID) {
		return congViecDao.findByID(ID);
	}

	@Override
	public List<CongViecMinhHQ> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		return congViecDao.findAll(iDisplayStart, iDisplayLength, sql);
	}

	@Override
	@Transactional
	public List<TrangThaiMinhHQ> trangThai() {
		return congViecDao.trangThai();
	}

	@Override
	@Transactional
	public List<LoaiCongViecMinhHQ> loaiCongViec() {
		 return congViecDao.loaiCongViec();
	}

//	@Override
//	public String getRecordsTotal() {
//		return congViecDao.getRecordsTotal();
//	}
//
//	@Override
//	public String getRecordsFiltered(String sql) {
//		return congViecDao.getRecordsFiltered(sql);
//	}
	
//		String action = "<a href='/ffse-fbms/QuanLyNhiemVuMinhHQ/view/" 
//				+ ID + "'><i class='fa fa-eye'></i></a>"
//				+ "<a href='/ffse-fbms/QuanLyNhiemVuMinhHQ/edit/"
//				+ ID + "'><i class='fa fa-pencil'></i></a>"
//				+ "<a href='javascript:void(0);' data-toggle='modal' data-target='#confirm-delete' data-href='/ffse-fbms/QuanLyNhiemVuMinhHQ/delete/"
//				+ID + "'><i class='fa fa-trash'></i></a>";

//		return "[\"" + tenCongViec + "\",\"" + loaiCongViec + "\",\"" + moTa + "\",\"" + tgBatDau + "\",\"" + tgKetThuc + "\",\"" + phanCong + "\",\"" + tgDuKien + "\",\"" + trangThai + "\",\"" + duAn + "\",\"" +  action + "\"]";

}

