package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.StatusDAO;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Status;
@Service
public class StatusServiceImpl implements StatusService{
	@Autowired
	private StatusDAO statusDAO;
	@Override
	@Transactional
	public List<Status> findAll() {
		
		return statusDAO.findAll();
	}

	@Override
	@Transactional
	public Status findById(int id) {
	
		return statusDAO.findById(id);
	}

	@Override
	@Transactional
	public void addNew(Status status) {
		statusDAO.addNew(status);
		
	}

	@Override
	@Transactional
	public void update(Status status) {
		statusDAO.update(status);
		
	}

	@Override
	@Transactional
	public void delete(Status status) {
		statusDAO.delete(status);
		
	}

	@Override
	@Transactional
	public int checkNameStatus(String nameStatus) {
	
		return statusDAO.checkNameStatus(nameStatus);
	}

}
