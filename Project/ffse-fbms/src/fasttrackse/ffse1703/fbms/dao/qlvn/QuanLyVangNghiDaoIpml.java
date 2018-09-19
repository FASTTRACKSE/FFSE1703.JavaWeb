package fasttrackse.ffse1703.fbms.dao.qlvn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Repository
@Transactional(rollbackFor = Exception.class)
public class QuanLyVangNghiDaoIpml implements QuanLyVangNghiDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<ThongKeDonXinPhep> danhSachXinNghiChoDuyet() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '2'").getResultList();
		return list;
	}
	
	public List<ThongKeDonXinPhep> danhSachXinNghiDuyet() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '3'").getResultList();
		return list;
	}
	
	public List<ThongKeDonXinPhep> danhSachXinNghiNhap() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '1'").getResultList();
		return list;
	}
	
	@Override
	public List<ThongKeDonXinPhep> danhSachXinNghiTuChoi() {
		Session session = sessionFactory.getCurrentSession();
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '4'").getResultList();
		return list;
	}
	

	public List<LyDoXinNghi> loadAllLyDo(){
		Session session = sessionFactory.getCurrentSession();
		List<LyDoXinNghi> list = session.createQuery("from LyDoXinNghi").list();
		return list;
	}
	
	public List<TrangThai> loadAllTrangThai(){
		Session session = sessionFactory.getCurrentSession();
		List<TrangThai> list = session.createQuery("from TrangThai").list();
		return list;
	}
	
	public List<HoSoNhanVien> loadAllHoSo(){
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVien> list = session.createQuery("from HoSoNhanVien").list();
		return list;
		
	}
	
	public void create(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '1'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	}

	@Override
	public void createWalk(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '2'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	}

	@Override
	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '3'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	}

	@Override
	public void createfeedback(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '4'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	}

	public ThongKeDonXinPhep findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ThongKeDonXinPhep list = (ThongKeDonXinPhep) session.get(ThongKeDonXinPhep.class, id);
		return list;
	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}
	
	@Override
	public void updateNhap(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();;
		session.update(thongKeDonXinPhep);
		
	}
}
