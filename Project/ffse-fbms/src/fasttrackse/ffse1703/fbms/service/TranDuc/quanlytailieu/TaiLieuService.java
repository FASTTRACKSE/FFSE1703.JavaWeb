package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;

public interface TaiLieuService {
	public List<TaiLieu> listAll();

	public void addTL(TaiLieu tl);

	public void updateTL(TaiLieu tl);

	public void deleteTL(String maTL);

	public TaiLieu getTLbyID(String maTL);

	public List<TaiLieu> listAll(int start, int limit);

	public String getRecordsTotal();

	public String getRecordsFiltered(String sql);
}
