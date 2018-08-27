package hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hibernate.dao.SVDao;
import hibernate.model.SinhVien;

@Service
public class SVServiceImpl implements SVService {
	
	private SVDao svDao;

	public void setSvDao(SVDao svDao) {
		this.svDao = svDao;
	}

	@Override
	@Transactional
	public void addSV(SinhVien sv) {
		this.svDao.addSV(sv);
	}

	@Override
	@Transactional
	public void updateSV(SinhVien sv) {
		this.svDao.updateSV(sv);
	}

	@Override
	@Transactional
	public List<SinhVien> listSV() {
		return this.svDao.listSV();
	}

	@Override
	@Transactional
	public void deleteSV(int id) {
		this.svDao.deleteSV(id);
	}

	@Override
	@Transactional
	public SinhVien getSVbyID(int id) {
		return this.svDao.getSVbyID(id);
	}

}
