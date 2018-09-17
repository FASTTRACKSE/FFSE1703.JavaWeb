package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq.QLyNhiemVuDao;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViec;



// @Service
// public class CongViecServiceImpl implements CongViecService {


// 	@Autowired
// 	private QLyNhiemVuDao congViecDao;
// 	@Autowired
// 	private DatatableCVService datatableCVService;

// 	@Override
// 	public List<CongViec> findAll() {
// 		return congViecDao.findAll();
// 	}

// 	@Override
// 	public void addNew(CongViec cv) {
// 		congViecDao.addNew(cv);
// 	}

// 	@Override
// 	public void update(CongViec cv) {
// 		congViecDao.update(cv);
// 	}

// 	@Override
// 	public void delete(int ID) {
// 		congViecDao.delete(ID);
// 	}

// 	@Override
// 	public CongViec findByTenCongViec(int ID) {
// 		return congViecDao.findByID(ID);
// 	}

// 	@Override
// 	public List<CongViec> findAll(int iDisplayStart, int iDisplayLength, String sql) {
// 		return congViecDao.findAll(iDisplayStart, iDisplayLength, sql);
// 	}

// 	@Override
// 	public String getRecordsTotal() {
// 		return congViecDao.getRecordsTotal();
// 	}

// 	@Override
// 	public String getRecordsFiltered(String sql) {
// 		return congViecDao.getRecordsFiltered(sql);
// 	}
	
// 	@Override
// 	public String getSQL(HttpServletRequest request) {
// 		String selectQuery = "select cv from CongViec cv ";
// 		String[] columnNames = { "cv.tenCongViec", "cv.loaiCongViec", "cv.moTa", "cv.tgBatDau", "cv.tgKetThuc", "cv.phanCong", "cv.tgDuKien","cv.trangThai", "cv.duAn"};
// 		String customCondition = "1=1";
// 		String sql = datatableCVService.getSqlQuery(selectQuery, request, columnNames, customCondition);
// 		return sql;
// 	}

// 	@Override
// 	public String toJson(CongViec cv) {
// 		int ID = cv.getID();
// 		String tenCongViec = cv.getTenCongViec();
// 		String loaiCongViec = cv.getTenCongViec();
// 		String moTa = cv.getMoTa();
// 		String tgBatDau = cv.getTgBatDau();
// 		String tgKetThuc = cv.getTgKetThuc();
// 		String phanCong = cv.getPhanCong();
// 		String tgDuKien = cv.getTgDuKien();
// 		String trangThai = cv.getTrangThai();
// 		String duAn = cv.getDuAn();
// 		String action = "<a href='/ffse-fbms/QuanLyNhiemVuMinhHQ/view/" 
// 				+ ID + "'><i class='fa fa-eye'></i></a>"
// 				+ "<a href='/ffse-fbms/QuanLyNhiemVuMinhHQ/edit/"
// 				+ ID + "'><i class='fa fa-pencil'></i></a>"
// 				+ "<a href='javascript:void(0);' data-toggle='modal' data-target='#confirm-delete' data-href='/ffse-fbms/QuanLyNhiemVuMinhHQ/delete/"
// 				+ID + "'><i class='fa fa-trash'></i></a>";

// 		return "[\"" + tenCongViec + "\",\"" + loaiCongViec + "\",\"" + moTa + "\",\"" + tgBatDau + "\",\"" + tgKetThuc + "\",\"" + phanCong + "\",\"" + tgDuKien + "\",\"" + trangThai + "\",\"" + duAn + "\",\"" +  action + "\"]";
// 	}

// }
