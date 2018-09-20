package fasttrackse.ffse1703.fbms.service.qlvn1;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.dao.qlvn1.QuanLyVangNghiDao;
import fasttrackse.ffse1703.fbms.entity.qlvn1.QuanLyVangNghiEntity;

public class QuanLyVangNghiServiceImpl implements QuanLyVangNghiService {
	@Autowired
	private QuanLyVangNghiDao quanLyVangNghiDao;

	@Override
	@Transactional
	public List<QuanLyVangNghiEntity> findAll() {

		return quanLyVangNghiDao.findAll();
	}

	@Override
	@Transactional
	public void addNew(QuanLyVangNghiEntity nv) {
		quanLyVangNghiDao.addNew(nv);

	}

	@Override
	@Transactional
	public QuanLyVangNghiEntity findById(int id) {
		return quanLyVangNghiDao.findById(id);
	}

}
