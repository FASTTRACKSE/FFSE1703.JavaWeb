package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.LoaiHopDongDaoTT;
import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuocTichDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuocTichTT;

@Service
public class QuocTichServiceTTImpl implements QuocTichServiceTT{
	@Autowired
	private QuocTichDaoTT quocTichDaoTT;

	@Override
	public List<QuocTichTT> getAllQuocTich() {
		// TODO Auto-generated method stub
		return this.quocTichDaoTT.getAllQuocTich();
	}

}
