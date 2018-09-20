package fasttrackse.ffse1703.fbms.service.qlvn1;

import java.util.List;
import fasttrackse.ffse1703.fbms.entity.qlvn1.QuanLyVangNghiEntity;

public interface QuanLyVangNghiService {
	public List<QuanLyVangNghiEntity> findAll();
	public QuanLyVangNghiEntity findById(int id);
	public void addNew(QuanLyVangNghiEntity nv);
}
