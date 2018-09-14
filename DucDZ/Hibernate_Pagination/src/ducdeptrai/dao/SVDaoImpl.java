package ducdeptrai.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ducdeptrai.model.SinhVien;
@Repository
public class SVDaoImpl implements SVDao{
	@Autowired
	private SessionFactory sessionFac;
	
	public void setSession(SessionFactory sessionFac) {
		this.sessionFac = sessionFac;
	}

	@Override
	public void addSV(SinhVien sv) {
		Session session = sessionFac.getCurrentSession();
		session.persist(sv);
	}

	@Override
	public void updateSV(SinhVien sv) {
		sessionFac.getCurrentSession().update(sv);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> listSV(int start,int limit) {
		Session session = sessionFac.getCurrentSession();
		List<SinhVien> sv = session.createQuery("from SinhVien").
				setFirstResult(start).setMaxResults(limit).list();
		return sv;
	}

	@Override
	public void deleteSV(Integer id) {
		Session session = sessionFac.getCurrentSession();
		SinhVien sv = session.load(SinhVien.class, id);
		if(sv != null) {
			session.delete(sv);
		}
	}

	@Override
	public SinhVien getSVbyId(Integer id) {
		Session session = sessionFac.getCurrentSession();
		SinhVien sv = session.get(SinhVien.class, id);
		return sv;
	}

	@Override
	public int countSV() {
		Session session = sessionFac.getCurrentSession();
		int rowCount = session.createQuery("from SinhVien").list().size();
		return rowCount;
	}

	@Override
	public boolean checkSV(Integer id) {
		Session session = sessionFac.getCurrentSession();
		SinhVien sv = session.get(SinhVien.class, id);
		if (sv != null) {
			return true;
		}
		return false;
	}

}
