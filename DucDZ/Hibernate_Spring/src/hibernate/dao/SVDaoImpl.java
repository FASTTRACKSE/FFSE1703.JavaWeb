package hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import hibernate.model.SinhVien;

@Repository
public class SVDaoImpl implements SVDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addSV(SinhVien sv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sv);
	}

	@Override
	public void updateSV(SinhVien sv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sv);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SinhVien> listSV() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SinhVien> svList = session.createQuery("from SinhVien").list();
		for (SinhVien x : svList) {
			System.out.println("Student List::" + x);
		}
		return svList;
	}

	@Override
	public void deleteSV(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien sv = (SinhVien) session.load(SinhVien.class, new Integer(id));
		if (null != sv) {
			session.delete(sv);
		}
	}

	@Override
	public SinhVien getSVbyID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		SinhVien sv = (SinhVien) session.load(SinhVien.class, new Integer(id));
		System.out.println(sv);
		return sv;
	}

}
