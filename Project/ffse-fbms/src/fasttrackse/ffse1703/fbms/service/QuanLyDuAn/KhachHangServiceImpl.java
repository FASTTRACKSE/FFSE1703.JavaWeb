package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.QuanLyDuAn.KhachHangDao;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.KhachHang;
@Service
public class KhachHangServiceImpl implements KhachHangService {
	@Autowired
	KhachHangDao khachHangDao;

	public void setStudentDAO(KhachHangDao khachHangDao) {
		this.khachHangDao = khachHangDao;

	}

	@Override
	@Transactional
	public List<KhachHang>getAll() {
		return this.khachHangDao.getAll();
	}

	@Override
	@Transactional
	public KhachHang findById(String makh) {
		return this.khachHangDao.findById(makh) ;
	}

	@Override
	@Transactional
	public void add(KhachHang khachhang) {
		this.khachHangDao.create(khachhang);
	}

	@Override
	@Transactional
	public void update(KhachHang khachhang) {
		this.khachHangDao.update(khachhang);

	}

	@Override
	@Transactional
	public void delete(KhachHang khachhang) {
		this.khachHangDao.delete(khachhang);

	}

	@Override
	@Transactional
	public List<KhachHang> findAllForPaging(int startPosition, int maxResult) {
		return this.khachHangDao.findAllForPaging(startPosition, maxResult);
	}

}
