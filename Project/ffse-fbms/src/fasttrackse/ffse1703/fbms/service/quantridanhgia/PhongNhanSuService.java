package fasttrackse.ffse1703.fbms.service.quantridanhgia;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantridanhgia.PhongNhanSuDAO;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;

@Service
public class PhongNhanSuService {
	
	@Autowired
	public PhongNhanSuDAO dao;
	
	@Transactional
	public List<KyDanhGia> getListKyDanhGia() {
		return this.dao.getListKyDanhGia() ;
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
}
