package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface HoSoNhanVienPikalongDao {
	public List<HoSoNhanVienPikalong> listNhanVien();
	public void delete(int maNv);
	public void insert(HoSoNhanVienPikalong hoSoNhanVien);
	public String getAutoId();
	public HoSoNhanVienPikalong getHoSoNhanVienById(int maNv);
	public HoSoNhanVienPikalong getEdit(int maNv);
	public void update(HoSoNhanVienPikalong hoSoNhanVienPikalong);
<<<<<<< HEAD
=======
	
>>>>>>> 46d12abb8da1283b82fbfc16450d531c19366ca9
}
