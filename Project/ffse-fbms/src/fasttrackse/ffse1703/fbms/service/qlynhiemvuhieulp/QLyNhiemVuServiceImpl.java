package fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvuhieulp.QLyNhiemVuDao;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.DuAnEntityHieuLp;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaicongviecEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaitrangthaiEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;

@Service
public class QLyNhiemVuServiceImpl implements QLyNhiemVuService {
	@Autowired
	private QLyNhiemVuDao qLyNhiemVuDao;

	public List<QLyNhiemVuEntity> getAll(){
		return this.qLyNhiemVuDao.getAll();
	}

	@Override
	@Transactional
	public void delete(QLyNhiemVuEntity nv) {
		this.qLyNhiemVuDao.delete(nv);
	}
	
	@Override
	@Transactional
	public QLyNhiemVuEntity findById(int id) {
		// TODO Auto-generated method stub
		return this.qLyNhiemVuDao.findById(id) ;
	}

	@Override
	@Transactional
	public void add(QLyNhiemVuEntity nv) {
		this.qLyNhiemVuDao.create(nv);
	}
	@Override
	@Transactional
	public void update(QLyNhiemVuEntity nv) {
		this.qLyNhiemVuDao.update(nv);

	}

	@Override
	@Transactional
	public List<LoaitrangthaiEntity> trangThai() {	
		return this.qLyNhiemVuDao.trangThai();
	}

	@Override
	@Transactional
	public List<LoaicongviecEntity> congViec() {
		return this.qLyNhiemVuDao.congViec();
	}

	@Override
	@Transactional
	public List<DuAnEntityHieuLp> duAn() {
		return this.qLyNhiemVuDao.duAn();
	}


}
