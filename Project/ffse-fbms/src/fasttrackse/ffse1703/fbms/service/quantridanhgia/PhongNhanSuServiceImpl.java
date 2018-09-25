package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.PhongNhanSuDAOImpl;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.PhanCongDanhGia;

@Service
public class PhongNhanSuServiceImpl implements PhongNhanSuService {

	@Autowired
	public PhongNhanSuDAOImpl dao;

	@Transactional
	@Override
	public List<KyDanhGia> getListKyDanhGia() {
		return this.dao.getListKyDanhGia();
	}

	@Transactional
	@Override
	public void insertKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.insertKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public void updateKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.updateKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public KyDanhGia getKyDanhGia(int maKy) {
		return this.dao.getKyDanhGia(maKy);
	}

	@Transactional
	@Override
	public void deleteKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.deleteKyDanhGia(kyDanhGia);
	}

	@Transactional
	@Override
	public List<Integer> getNhanVienPhongBan(String phongBan) {
		return this.dao.getNhanVienPhongBan(phongBan);
	}

	@Transactional
	@Override
	public List<LichDanhGia> getListLichDanhGia() {
		return this.dao.getListLichDanhGia();
	}

	@Transactional
	@Override
	public int checkLichDanhGia(LichDanhGia lichDanhGia) {
		return this.dao.checkLichDanhGia(lichDanhGia);
	}

	@Transactional
	@Override
	public void insertLichDanhGia(LichDanhGia lichDanhGia) {
		this.dao.insertLichDanhGia(lichDanhGia);
	}

	@Transactional
	@Override
	public LichDanhGia getLichDanhGia(int id) {
		return this.dao.getLichDanhGia(id);
	}

	@Transactional
	@Override
	public void activeLichDanhGia(LichDanhGia lichDanhGia) {
		this.dao.activeLichDanhGia(lichDanhGia);
	}

	@Transactional
	@Override
	public void insertPhanCongDanhGia(List<PhanCongDanhGia> pc) {
		this.dao.insertPhanCongDanhGia(pc);
	}

	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan() {
		return this.dao.getListDanhGiaBanThan();
	}
	
	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThanByKyDanhGia(String kyDanhGia) {
		return this.dao.getListDanhGiaBanThanByKyDanhGia(kyDanhGia);
	}
	
	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThanByPhongBan(String phongBan) {
		return this.dao.getListDanhGiaBanThanByPhongBan(phongBan);
	}
	
	@Transactional
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan(String kyDanhGia, String phongBan) {
		return this.dao.getListDanhGiaBanThan(kyDanhGia, phongBan);
	}
}
