package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu.TaiLieuDao;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
@Service
public class TaiLieuServiceImpl implements TaiLieuService {
	@Autowired
	private TaiLieuDao daoTL;
	@Override
	public List<TaiLieu> listAll() {
		return daoTL.listAll();
	}

	@Override
	public void addTL(TaiLieu tl) {
		daoTL.addTL(tl);
	}

	@Override
	public void updateTL(TaiLieu tl) {
		daoTL.updateTL(tl);
	}

	@Override
	public void deleteTL(String maTL) {
		daoTL.deleteTL(maTL);
	}

	@Override
	public TaiLieu getTLbyID(String maTL) {
		return daoTL.getTLbyID(maTL);
	}

	@Override
	public List<TaiLieu> listAll(int start, int limit) {
		return daoTL.listAll(start,limit);
	}

	@Override
	public String getRecordsTotal() {
		return daoTL.getRecordsTotal();
	}

	@Override
	public String getRecordsFiltered(String sql) {
		return daoTL.getRecordsFiltered(sql);
	}

}
