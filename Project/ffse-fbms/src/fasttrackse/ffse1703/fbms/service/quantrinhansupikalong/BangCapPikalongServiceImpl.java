package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong.BangCapPikalongDao;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;
@Service
public class BangCapPikalongServiceImpl implements BangCapPikalongService {
	@Autowired
	private BangCapPikalongDao BangCapPikalongDao;
	
	public void setBangCapPikalongDao(BangCapPikalongDao bangCapPikalongDao) {
		BangCapPikalongDao = bangCapPikalongDao;
	}

	@Override
	@Transactional
	public void addBangCapPikalong(BangCapPikalong p) {
		this.BangCapPikalongDao.addBangCapPikalong(p);
		
	}

	@Override
	@Transactional
	public void updateBangCapPikalong(BangCapPikalong p) {
		this.BangCapPikalongDao.updateBangCapPikalong(p);
		
	}

	@Override
	@Transactional
	public List<BangCapPikalong> listBangCapPikalong() {
		// TODO Auto-generated method stub
		return this.BangCapPikalongDao.listBangCapPikalong();
	}

	@Override
	@Transactional
	public BangCapPikalong getBangCapPikalongById(int id) {
		// TODO Auto-generated method stub
		return this.BangCapPikalongDao.getBangCapPikalongById(id);
	}

	@Override
	@Transactional
	public void removeBangCapPikalong(int id) {
		this.BangCapPikalongDao.removeBangCapPikalong(id);
		
	}

	@Override
	@Transactional
	public int total() {
		// TODO Auto-generated method stub
		return 0;
	}

}
