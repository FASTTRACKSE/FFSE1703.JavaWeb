package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
@Repository
public class DanhMucImpl implements DanhMucDao{
	@Autowired
	private SessionFactory session;
	
	@Override
	public List<DanhMuc> listAllDanhMuc() {
		return null;
	}

	@Override
	public void addDM(DanhMuc dm) {
		
	}

	@Override
	public void updateDM(DanhMuc dm) {
		
	}

	@Override
	public void deleteDM(DanhMuc dm) {
		
	}

	@Override
	public DanhMuc getDMbyID(int id) {
		return null;
	}

	@Override
	public List<DanhMuc> listAllDanhMuc(int start, int limit) {
		return null;
	}

	@Override
	public String getRecordTotal() {
		return null;
	}

	@Override
	public String getRecordFiltered(String sql) {
		return null;
	}

}
