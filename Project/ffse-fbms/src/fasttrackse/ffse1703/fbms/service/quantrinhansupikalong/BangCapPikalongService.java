package fasttrackse.ffse1703.fbms.service.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;

public interface BangCapPikalongService {
	public void addBangCapPikalong(BangCapPikalong p);
	public void updateBangCapPikalong(BangCapPikalong p);
	public List<BangCapPikalong> listBangCapPikalong();
	public BangCapPikalong getBangCapPikalongById(int id);
	public void removeBangCapPikalong(int id);
	public int total();
}
