package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.HoSoNhanVienPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;


@Service
public class HoSoNhanVienPikalongServiceImpl implements HoSoNhanVienPikalongService {
	@Autowired
	private HoSoNhanVienPikalongDao hoSoNhanVienPikalongDao;
	
	public void setHoSoNhanVienPikalongDao(HoSoNhanVienPikalongDao hoSoNhanVienPikalongDao) {
		this.hoSoNhanVienPikalongDao = hoSoNhanVienPikalongDao;
	}


	@Override
	@Transactional
	public List<HoSoNhanVienPikalong> listNhanVien() {
		
		return hoSoNhanVienPikalongDao.listNhanVien();
	}


	@Override
	@Transactional
	public void delete(int maNv) {
		hoSoNhanVienPikalongDao.delete(maNv);
	}


	@Override
	@Transactional
	public void insert(HoSoNhanVienPikalong hoSoNhanVien) {
		hoSoNhanVienPikalongDao.insert(hoSoNhanVien);
		
	}

}
