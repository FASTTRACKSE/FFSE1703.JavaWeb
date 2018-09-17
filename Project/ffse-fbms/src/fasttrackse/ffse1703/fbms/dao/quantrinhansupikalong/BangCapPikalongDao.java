package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;

public interface BangCapPikalongDao {
	public void addBangCapPikalong(BangCapPikalong p);
	public void updateBangCapPikalong(BangCapPikalong p);
	public List<BangCapPikalong> listBangCapPikalong();
	public BangCapPikalong getBangCapPikalongById(int id);
	public void removeBangCapPikalong(int id);
	public int total();
}
