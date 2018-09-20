package fasttrackse.ffse1703.fbms.service.qlvn1;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlvn1.QuanLyVangNghiDao;
import fasttrackse.ffse1703.fbms.entity.qlvn1.QuanLyVangNghiEntity;

@Service
public class QuanLyVangNghiServiceImpl implements QuanLyVangNghiService {
	private QuanLyVangNghiDao qlvnDao;
	
	public void setQuanLyVangNghiDao(QuanLyVangNghiDao personDAO) {
		this.qlvnDao = qlvnDao;
	}
	
	@Transactional
	@Override
	public void addDon(QuanLyVangNghiEntity dn) {
		this.qlvnDao.addDon(dn);
		
	}
	

}
