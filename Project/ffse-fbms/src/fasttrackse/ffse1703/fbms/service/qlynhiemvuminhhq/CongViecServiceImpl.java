package fasttrackse.ffse1703.fbms.service.qlynhiemvuminhhq;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq.QLyNhiemvuMinhHQDao;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.DuAnMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;



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
	@Transactional
	public void addNew(CongViecMinhHQ cv) {
		congViecDao.addNew(cv);
	}

	@Override
	@Transactional
	public void update(CongViecMinhHQ cv) {
		congViecDao.update(cv);
	}

	@Override
	@Transactional
	public void delete(CongViecMinhHQ cv) {
		congViecDao.delete(cv);
	}

	@Override
	@Transactional
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

	@Override
	@Transactional
	public List<DuAnMinhHQ> duAn() {
		return congViecDao.duAn();
	}

	@Override
	@Transactional
	public List<HoSoNhanVien> nhanVien() {
		return congViecDao.nhanVien();
	}

	@Override
	@Transactional
	public List<CongViecMinhHQ> findAllForPaging(int startPosition, int maxResult) {
		return congViecDao.findAllForPaging(startPosition,maxResult);
	}

}

