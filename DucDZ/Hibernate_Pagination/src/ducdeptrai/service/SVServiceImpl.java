package ducdeptrai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ducdeptrai.dao.SVDao;
import ducdeptrai.model.SinhVien;
@Service
public class SVServiceImpl implements SVService {

	@Autowired
	private SVDao dao;

	public void setDao(SVDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public void addSV(SinhVien sv) {
		this.dao.addSV(sv);
	}

	@Override
	@Transactional
	public void update(SinhVien sv) {
		this.dao.updateSV(sv);
	}

	@Override
	@Transactional
	public void deleteSV(Integer id) {
		this.dao.deleteSV(id);
	}

	@Override
	@Transactional
	public SinhVien getSVbyId(Integer id) {
		return this.dao.getSVbyId(id);
	}
	
	@Transactional
	@Override
	public int countSV() {
		return this.dao.countSV();
	}

	@Override
	@Transactional
	public List<SinhVien> listSV(int start, int limit) {
		return this.dao.listSV(start, limit);
	}

	@Override
	@Transactional
	public boolean checkSV(Integer id) {
		return this.dao.checkSV(id);
	}

}
