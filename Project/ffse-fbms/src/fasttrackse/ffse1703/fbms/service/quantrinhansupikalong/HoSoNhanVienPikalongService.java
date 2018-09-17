package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HoSoNhanVienPikalong;


public interface HoSoNhanVienPikalongService {
	public List<HoSoNhanVienPikalong> listNhanVien();
	public void delete(int maNv);
	
}
