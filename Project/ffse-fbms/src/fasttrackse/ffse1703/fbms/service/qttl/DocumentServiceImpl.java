package fasttrackse.ffse1703.fbms.service.qttl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.entity.qttl.*;
import fasttrackse.ffse1703.fbms.dao.qttl.*;

@Service
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	private DocumentDAO documentDao;

	@Transactional
	public List<Document> getAll() {
		 return this.documentDao.getAll();
	}

	@Transactional
	public void addNew(Document document) {
		this.documentDao.addNew(document);
	}

	@Transactional
	public void update(Document document) {
		this.documentDao.update(document);
	}

	@Transactional
	public void delete(int id) {
		this.documentDao.delete(id);
	}

	@Transactional
	public Document getById(int id) {
		return this.documentDao.getById(id);
	}

	
	
}
