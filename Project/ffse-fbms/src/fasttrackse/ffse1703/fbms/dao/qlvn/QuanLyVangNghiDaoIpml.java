package fasttrackse.ffse1703.fbms.dao.qlvn;

import java.util.Date;
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
@Transactional
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
		List<TrangThai> list = session.createSQLQuery("select * from trang_thai").list();
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

	
	public void createWalk(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '2'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	}

	
	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
//		Date ngayBatDau = thongKeDonXinPhep.getNgayBatDau();
//		Date ngayKT = thongKeDonXinPhep.getNgayKetThuc();
//		System.out.println((ngayKT.getTime()-ngayBatDau.getTime())/ (60 * 60 * 1000));
		session.save(thongKeDonXinPhep);
		/*if(soNgayConLai == 0) {
			session.createQuery("update ThongKeNgayNghi set so_ngay_da_nghi = " + (soNgayNghi + soNgayDaNghi)
			+ "where ma_nhan_vien = " + maNhanVien ).executeUpdate();
		} else if(soNgayNghi>soNgayConLai) {
			session.createQuery("update ThongKeNgayNghi set so_ngay_con_lai = 0, so_ngay_da_nghi = " + (soNgayNghi + soNgayDaNghi)
					+ "where ma_nhan_vien = " + maNhanVien ).executeUpdate();
		} else {session.createQuery("update ThongKeNgayNghi set so_ngay_con_lai =  " + (soNgayConLai + soNgayDaNghi)
				+ ",so_ngay_da_nghi =" + (soNgayDaNghi + soNgayNghi) + "where ma_nhan_vien = " + maNhanVien ).executeUpdate();
			*/
		session.createQuery("update ThongKeDonXinPhep set trangThai = '3'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	}


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
	
	
	public void updateNhap(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();;
		session.update(thongKeDonXinPhep);
		
	}
}
