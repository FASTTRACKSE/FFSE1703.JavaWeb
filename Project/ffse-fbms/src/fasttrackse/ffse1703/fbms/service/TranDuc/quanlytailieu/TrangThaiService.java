package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;

public interface TrangThaiService {
	public List<TrangThai> listAllTrangThai();

	public void addTT(TrangThai tt);

	public void updateTT(TrangThai tt);

	public void deleteTT(int id);

	public TrangThai getTTbyID(int id);

}
