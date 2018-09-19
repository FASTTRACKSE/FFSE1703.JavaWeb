package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;

public interface HoSoNhanVienPikalongDao {
	public List<HoSoNhanVienPikalong> listNhanVien();
	public void delete(int maNv);
	
}
