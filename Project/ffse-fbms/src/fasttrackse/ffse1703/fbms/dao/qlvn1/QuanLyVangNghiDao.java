package fasttrackse.ffse1703.fbms.dao.qlvn1;
import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
public interface QuanLyVangNghiDao {
	public void addDon(DonNghi dn);
	public List<DonNghi> listDonNghi();
	public UserAccount getThongTinUser(String username);
	public TinhTrangNghi getTinhTrang(int id_nv);
	public List<LyDo> listLyDo();
	public void insertTinhTrang(int id_nv, TinhTrangNghi tt);
}
