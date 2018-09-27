package fasttrackse.ffse1703.fbms.service.qlvn2;

import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.qlvn2.DonXinPhepDao;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Service
@Transactional
public class DonXinPhepServicelmpl implements DonXinPhepService {
	@Autowired 
	DonXinPhepDao DonXinPhepDao;
	

	public void setDonXinPhepDao(DonXinPhepDao donXinPhepDao) {
		DonXinPhepDao = donXinPhepDao;
	}

	public List<DonXinPhepEntity> danhsachnhap003() {
		return this.DonXinPhepDao.danhsachnhap003();
	}

	
	public List<DonXinPhepEntity> danhsachchoduyet003() {
		return this.DonXinPhepDao.danhsachchoduyet003();
	}


	public List<DonXinPhepEntity> danhsachdaduyet003() {
		return this.DonXinPhepDao.danhsachdaduyet003();
	}

	
	public List<DonXinPhepEntity> danhsachbituchoi003() {
		return this.DonXinPhepDao.danhsachbituchoi003();
		}

	
	public List<LyDoEntity> danhSachLyDo() {
		return this.DonXinPhepDao.danhSachLyDo();
	}

	
	public List<TrangThaiEntity> danhSachTrangThai() {
		return this.DonXinPhepDao.danhSachTrangThai();
	}

	
	public List<HoSoNhanVien> danhSachHoSo() {
	return this.DonXinPhepDao.danhSachHoSo();
	}

	
	public void create(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.create(DonXinPhepEntity);
		
	}
	
	public void createcho(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.createcho(DonXinPhepEntity);
		
	}

	
	public void createduyet(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.createduyet(DonXinPhepEntity);
		
	}

	
	public void createtuchoi(DonXinPhepEntity DonXinPhepEntity) {
		DonXinPhepDao.createtuchoi(DonXinPhepEntity);
		
	}

	
	public DonXinPhepEntity findById(int id) {
		return this.DonXinPhepDao.findById(id);
	}

	public void delete(int id) {
	DonXinPhepDao.delete(id);
		
	}

	

	
	

	


}
