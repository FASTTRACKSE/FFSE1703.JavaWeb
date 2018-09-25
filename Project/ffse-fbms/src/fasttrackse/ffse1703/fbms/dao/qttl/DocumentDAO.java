package fasttrackse.ffse1703.fbms.dao.qttl;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qttl.*;

public interface DocumentDAO {

	public List<Document> getAll();

	public void delete(int id);

	public void addNew(Document document);

	public Document getById(int id);

	public void update(Document document);

}
