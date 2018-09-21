package fasttrackse.ffse1703.fbms.service.qlvn2;

import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.qlvn2.DonXinPhepDao;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
public class DonXinPhepServicelmpl implements DonXinPhepService {
	@Autowired 
	DonXinPhepDao DonXinPhepDao;

	public void setDonXinPhepDao(DonXinPhepDao donXinPhepDao) {
		DonXinPhepDao = donXinPhepDao;
	}

	@Override
	@Transactional
	public List<DonXinPhepEntity> danhsachnhap003() {
		return this.DonXinPhepDao.danhsachnhap003();
	}
	
	@Override
	@Transactional
	public List<DonXinPhepEntity> danhsachdaduyet003() {
		return this.DonXinPhepDao.danhsachdaduyet003();
	}

	@Override
	@Transactional
	public List<DonXinPhepEntity> danhsachchoduyet003() {
	
		return this.DonXinPhepDao.danhsachchoduyet003();
	}

	@Override
	@Transactional
	public List<DonXinPhepEntity> danhsachbituchoi003() {
		return this.DonXinPhepDao.danhsachbituchoi003();
	}
	@Override
	@Transactional
	public void add(DonXinPhepEntity DonXinPhepEntity) {
		this.DonXinPhepDao.donxinphep003(DonXinPhepEntity);
	}

	@Override
	public DonXinPhepEntity findById(int id) {
		return this.DonXinPhepDao.findById(id);
	}

//	@Override
//	public List<LyDoEntity> danhsachlyDo() {
//		return this.DonXinPhepDao.danhsachlyDo();
//	}
//
//	@Override
//	public List<TrangThaiEntity> danhsachTrangThai() {
//		return this.DonXinPhepDao.danhsachTrangThai();
//	}
//
//	@Override
//	public List<HoSoNhanVien> danhsachHoSo() {
//		return this.DonXinPhepDao.danhsachHoSo();
//	}
}
