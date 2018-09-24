package fasttrackse.ffse1703.fbms.dao.qlvn2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Repository
@Transactional
public class DonXinPhepDaolmpl implements DonXinPhepDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<DonXinPhepEntity> danhsachnhap003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity where trangThai = '1'").getResultList();
		return list;
	}
	@Override
	public List<DonXinPhepEntity> danhsachchoduyet003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity  where trangThai = '2'").getResultList();
		return list;
	}
	@Override
	public List<DonXinPhepEntity> danhsachdaduyet003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity  where trangThai = '3'").getResultList();
		return list;
	}
	@Override
	public List<DonXinPhepEntity> danhsachbituchoi003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity  where trangThai = '4'").getResultList();
		return list;
	}
	@Override
	public void donxinphep003(DonXinPhepEntity DonXinPhepEntity) {
		
			Session session = this.sessionFactory.getCurrentSession();
			session.save(DonXinPhepEntity);
			session.createQuery("update ThongKeDonXinPhep set trangThai = '1'  where id =" + DonXinPhepEntity.getId()).executeUpdate();
			
	}
	@Override
	public List<LyDoEntity> danhSachLyDo() {
		Session session = sessionFactory.getCurrentSession();
		List<LyDoEntity> list = session.createQuery("from LyDoEntity").list();
		return list;
	}
	@Override
	public List<TrangThaiEntity> danhSachTrangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiEntity> list = session.createQuery("from TrangThaiEntity").list();
		return list;
	}
	@Override
	public List<HoSoNhanVien> danhSachHoSo() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVien> list = session.createQuery("from HoSoNhanVien").list();
		return list;
	}

	

}
