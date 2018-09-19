package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.QuanLyDuAn.KhachHangDaoTeam1;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.KhachHangTeam1;
@Service
public class KhachHangServiceImplTeam1 implements KhachHangServiceTeam1 {
	@Autowired
	KhachHangDaoTeam1 khachHangDaoTeam1;

	public void setStudentDAO(KhachHangDaoTeam1 khachHangDaoTeam1) {
		this.khachHangDaoTeam1 = khachHangDaoTeam1;

	}

	@Override
	@Transactional
	public List<KhachHangTeam1>getAll() {
		return this.khachHangDaoTeam1.getAll();
	}

	@Override
	@Transactional
	public KhachHangTeam1 findById(String makh) {
		return this.khachHangDaoTeam1.findById(makh) ;
	}

	@Override
	@Transactional
	public void add(KhachHangTeam1 khachhang) {
		this.khachHangDaoTeam1.create(khachhang);
	}

	@Override
	@Transactional
	public void update(KhachHangTeam1 khachhang) {
		this.khachHangDaoTeam1.update(khachhang);

	}

	@Override
	@Transactional
	public void delete(KhachHangTeam1 khachhang) {
		this.khachHangDaoTeam1.delete(khachhang);

	}

	@Override
	@Transactional
	public List<KhachHangTeam1> findAllForPaging(int startPosition, int maxResult) {
		return this.khachHangDaoTeam1.findAllForPaging(startPosition, maxResult);
	}

}
