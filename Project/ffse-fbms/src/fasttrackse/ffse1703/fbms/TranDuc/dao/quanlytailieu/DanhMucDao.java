package fasttrackse.ffse1703.fbms.TranDuc.dao.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.TranDuc.entity.quanlytailieu.DanhMuc;

public interface DanhMucDao {
	public List<DanhMuc> listAllDanhMuc();

	public void addDM(DanhMuc dm);

	public void updateDM(DanhMuc dm);

	public void deleteDM(DanhMuc dm);

	public DanhMuc getDMbyID(int id);
	
	public List<DanhMuc> listAllDanhMuc(int start, int limit);

	public String getRecordTotal();
	
	public String getRecordFiltered(String sql);
}
