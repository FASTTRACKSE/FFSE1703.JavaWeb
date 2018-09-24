package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.PhongNhanSuDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.PhanCongDanhGia;

@Service
public class PhongNhanSuService {

	@Autowired
	public PhongNhanSuDAO dao;

	@Transactional
	public List<KyDanhGia> getListKyDanhGia() {
		return this.dao.getListKyDanhGia();
	}

	@Transactional
	public void insertKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.insertKyDanhGia(kyDanhGia);
	}

	@Transactional
	public void updateKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.updateKyDanhGia(kyDanhGia);
	}

	@Transactional
	public KyDanhGia getKyDanhGia(int maKy) {
		return this.dao.getKyDanhGia(maKy);
	}

	@Transactional
	public void deleteKyDanhGia(KyDanhGia kyDanhGia) {
		this.dao.deleteKyDanhGia(kyDanhGia);
	}

	@Transactional
	public List<Integer> getNhanVienPhongBan(String phongBan) {
		return this.dao.getNhanVienPhongBan(phongBan);
	}

	@Transactional
	public List<LichDanhGia> getListLichDanhGia() {
		return this.dao.getListLichDanhGia();
	}

	@Transactional
	public int checkLichDanhGia(LichDanhGia lichDanhGia) {
		return this.dao.checkLichDanhGia(lichDanhGia);
	}

	@Transactional
	public void insertLichDanhGia(LichDanhGia lichDanhGia) {
		this.dao.insertLichDanhGia(lichDanhGia);
	}

	@Transactional
	public LichDanhGia getLichDanhGia(int id) {
		return this.dao.getLichDanhGia(id);
	}

	@Transactional
	public void activeLichDanhGia(LichDanhGia lichDanhGia) {
		this.dao.activeLichDanhGia(lichDanhGia);
	}

	@Transactional
	public void insertPhanCongDanhGia(List<PhanCongDanhGia> pc) {
		this.dao.insertPhanCongDanhGia(pc);
	}

	@Transactional
	public List<DanhGiaBanThan> getListDanhGiaBanThan() {
		return this.dao.getListDanhGiaBanThan();
	}
	
	@Transactional
	public List<DanhGiaBanThan> getListDanhGiaBanThanByKyDanhGia(String kyDanhGia) {
		return this.dao.getListDanhGiaBanThanByKyDanhGia(kyDanhGia);
	}
	
	@Transactional
	public List<DanhGiaBanThan> getListDanhGiaBanThanByPhongBan(String phongBan) {
		return this.dao.getListDanhGiaBanThanByPhongBan(phongBan);
	}
	
	@Transactional
	public List<DanhGiaBanThan> getListDanhGiaBanThan(String kyDanhGia, String phongBan) {
		return this.dao.getListDanhGiaBanThan(kyDanhGia, phongBan);
	}
}
