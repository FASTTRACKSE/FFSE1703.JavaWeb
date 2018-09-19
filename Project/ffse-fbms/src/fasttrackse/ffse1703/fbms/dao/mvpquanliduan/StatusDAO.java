package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Status;

public interface StatusDAO {
	public List<Status> findAll();
	public Status findById(int id);
	public void addNew(Status status);
	public void update(Status status);
	public void delete(Status status);
	public int checkNameStatus(String nameStatus);
}
