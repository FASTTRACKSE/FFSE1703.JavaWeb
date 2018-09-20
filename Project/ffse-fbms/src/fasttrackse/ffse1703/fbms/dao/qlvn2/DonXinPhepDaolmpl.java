package fasttrackse.ffse1703.fbms.dao.qlvn2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
@Repository
public class DonXinPhepDaolmpl implements DonXinPhepDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DonXinPhepEntity> danhsachnhap003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity where trangThai = '1'",DonXinPhepEntity.class).list();
	}

	
	@Override
	public List<DonXinPhepEntity> danhsachdaduyet003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity where trangThai = '2'",DonXinPhepEntity.class).list();
	}
	@Override
	public List<DonXinPhepEntity> danhsachchoduyet003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity  where trangThai = '3'",DonXinPhepEntity.class).list();
	}
	@Override
	public List<DonXinPhepEntity> danhsachbituchoi003() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity  where trangThai = '4'",DonXinPhepEntity.class).list();
	}
	public void donxinphep003(DonXinPhepEntity DonXinPhepEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(DonXinPhepEntity);
		
	}
//	@Override
//	public List<LyDoEntity> danhsachlyDo() {
//		Session session = sessionFactory.getCurrentSession();
//		List<LyDoEntity> list = session.createQuery("from DonXinPhepEntity").list();
//		return list;
//	}
//	@Override
//	public List<TrangThaiEntity> danhsachTrangThai() {
//		Session session = sessionFactory.getCurrentSession();
//		List<TrangThaiEntity> list = session.createQuery("from TrangThaiEntity").list();
//		return list;
//	}
//	@Override
//	public List<HoSoNhanVien> danhsachHoSo() {
//		Session session = sessionFactory.getCurrentSession();
//		List<HoSoNhanVien> list = session.createQuery("from HoSoNhanVien").list();
//		return list;
//	}
	@Override
	public DonXinPhepEntity findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		DonXinPhepEntity list = (DonXinPhepEntity) session.get(DonXinPhepEntity.class, id);
		return list;
	}
}
