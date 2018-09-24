package fasttrackse.ffse1703.fbms.service.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.mvpquanliduan.FrameworkDao;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Framework;
@Service
@Transactional
public class FrameworkServiceImpl implements FrameworkService {
	@Autowired
	private FrameworkDao frameworkDao;
	@Override
	
	public List<Framework> getAll() {
		return this.frameworkDao.getAll();
	}

	@Override
	@Transactional
	public Framework getById(int id) {
		return frameworkDao.getById(id);
	}

	@Override
	@Transactional
	public void add(Framework framework) {
		frameworkDao.add(framework);
		
	}

	@Override
	@Transactional
	public void update(Framework framework) {
		frameworkDao.update(framework);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		frameworkDao.delete(id);
	}

	@Override
	@Transactional
	public int checkNameFramework(String nameFramework) {
		
		return frameworkDao.checkNameFramework(nameFramework);
	}

}
