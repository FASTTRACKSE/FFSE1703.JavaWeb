package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
@Repository
public class TaiLieuDaoImpl implements TaiLieuDao {
	@Autowired
	private SessionFactory session;
	
	public void setSession(SessionFactory session) {
		this.session = session;
	}

	@Override
	public List<TaiLieu> listAll() {
		return null;
	}

	@Override
	public void addTL(TaiLieu tl) {
		
	}

	@Override
	public void updateTL(TaiLieu tl) {
		
	}

	@Override
	public void deleteTL(String maTL) {
		
	}

	@Override
	public TaiLieu getTLbyID(String maTL) {
		return null;
	}

	@Override
	public List<TaiLieu> listAll(int start, int limit) {
		return null;
	}

	@Override
	public String getRecordsTotal() {
		return null;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		return null;
	}

}
