package fasttrackse.ffse1703.fbms.dao.qlynhiemvuminhhq;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.CongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.DuAnMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.LoaiCongViecMinhHQ;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuminhhq.TrangThaiMinhHQ;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;



@Repository
public class QLyNhiemvuMinhHQDaoImpl implements QLyNhiemvuMinhHQDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<CongViecMinhHQ> findAll() {
		Session session = this.sessionFactory.openSession();
		List<CongViecMinhHQ> list = session.createQuery("from CongViecMinhHQ where isDelete ='1'").list();
		return list;
	}

	@Override
	public void addNew(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(cv);
	}

	@Override
	public void update(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cv);
	}

	@Override
	public void delete(CongViecMinhHQ cv) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cv);
	}

	@Override
	public CongViecMinhHQ findByID(int ID) {
		Session session = this.sessionFactory.getCurrentSession();
		CongViecMinhHQ pb = session.get(CongViecMinhHQ.class, ID);
		return pb;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CongViecMinhHQ> findAll(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.openSession();
		List<CongViecMinhHQ> listCongViec = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return listCongViec;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrangThaiMinhHQ> trangThai() {
		Session session = sessionFactory.openSession();
		List<TrangThaiMinhHQ> tt = session.createQuery("from TrangThaiMinhHQ").list();
		return tt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoaiCongViecMinhHQ> loaiCongViec() {
		Session session = sessionFactory.openSession();
		List<LoaiCongViecMinhHQ> cv = session.createQuery("from LoaiCongViecMinhHQ").list();
		return cv;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DuAnMinhHQ> duAn() {
		Session session = sessionFactory.openSession();
		List<DuAnMinhHQ> da = session.createQuery("from DuAnMinhHQ").list();
		return da;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> nhanVien() {
		Session session = sessionFactory.openSession();
		List<HoSoNhanVien> cv = session.createQuery("from HoSoNhanVien").list();
		return cv;
	}

//	@Override
//	public String getRecordsTotal() {
//		Session session = this.sessionFactory.openSession();
//
//		String sql = "SELECT COUNT(*) FROM `cong_viec`";
//		Query query = session.createSQLQuery(sql);
//
//		String recordsTotal = query.getSingleResult().toString();
//		session.close();
//		return recordsTotal;
//	}
//
//	@Override
//	public String getRecordsFiltered(String sql) {
//		Session session = this.sessionFactory.openSession();
//		Query query = session.createQuery(sql.replace("select cv", "select count(*)"));
//		String recordsFiltered = query.getSingleResult().toString();
//		session.close();
//		return recordsFiltered;
//	}
}

