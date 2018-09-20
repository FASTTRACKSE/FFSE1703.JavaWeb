package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq.*;
 import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViec;



@Service
public class CongViecServiceImpl implements CongViecService{



	@Autowired
	private QLyNhiemvuMinhHQDao congViecDao;
	
	@Override
	@Transactional
	public List<CongViec> findAll() {
		return congViecDao.findAll();
	}

	@Override
	public void addNew(CongViec cv) {
		congViecDao.addNew(cv);
	}

	@Override
	@Transactional
	public void update(CongViec cv) {
		congViecDao.update(cv);
	}

	@Override
	@Transactional
	public void delete(CongViec cv) {
		congViecDao.delete(cv);
	}

	@Override
	public CongViec findByID(int ID) {
		return congViecDao.findByID(ID);
	}

	@Override
	public List<CongViec> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		return congViecDao.findAll(iDisplayStart, iDisplayLength, sql);
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

