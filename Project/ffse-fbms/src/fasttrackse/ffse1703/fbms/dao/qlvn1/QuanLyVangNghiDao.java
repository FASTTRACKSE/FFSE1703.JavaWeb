package fasttrackse.ffse1703.fbms.dao.qlvn1;

import java.util.List;
import fasttrackse.ffse1703.fbms.entity.qlvn1.QuanLyVangNghiEntity;

public interface QuanLyVangNghiDao {
	public List<QuanLyVangNghiEntity> findAll();
	public QuanLyVangNghiEntity findById(int id);
	public void addNew(QuanLyVangNghiEntity nv);
}
