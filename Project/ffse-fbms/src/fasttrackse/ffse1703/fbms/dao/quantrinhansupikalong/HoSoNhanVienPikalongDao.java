package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface HoSoNhanVienPikalongDao {
	public List<HoSoNhanVienPikalong> listNhanVien();
	public void delete(int maNv);
	public void insert(HoSoNhanVienPikalong hoSoNhanVien);
<<<<<<< HEAD
	public String getAutoId();
	public HoSoNhanVienPikalong getHoSoNhanVienById(int maNv);
=======
	public HoSoNhanVienPikalong getEdit(int maNv);
	public void update(HoSoNhanVienPikalong hoSoNhanVienPikalong);
	
>>>>>>> e35fba4e52e720df83037cbed03dccf3df2c6dba
}
