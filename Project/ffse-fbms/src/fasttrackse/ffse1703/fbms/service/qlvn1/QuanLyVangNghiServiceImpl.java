package fasttrackse.ffse1703.fbms.service.qlvn1;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlvn1.QuanLyVangNghiDao;
import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

@Service
public class QuanLyVangNghiServiceImpl implements QuanLyVangNghiService {
	@Autowired
	private QuanLyVangNghiDao qlvnDao;
	
	public void setQuanLyVangNghiDao(QuanLyVangNghiDao personDAO) {
		this.qlvnDao = personDAO;
	}
	
	@Transactional
	@Override
	public void addDon(DonNghi dn) {
		this.qlvnDao.addDon(dn);
		
	}
	
	@Transactional
	@Override
	public List<DonNghi> listDonNghi() {
	
		return this.qlvnDao.listDonNghi();
	}

	@Transactional
	@Override
	public UserAccount getThongTinUser(String username) {
		return this.qlvnDao.getThongTinUser(username);
	}

	@Transactional
	@Override
	public TinhTrangNghi getTinhTrang(int id_nv) {
		return this.qlvnDao.getTinhTrang(id_nv);
	}

	@Transactional
	@Override
	public List<LyDo> listLyDo() {
		return this.qlvnDao.listLyDo();
	}

	
	

}
