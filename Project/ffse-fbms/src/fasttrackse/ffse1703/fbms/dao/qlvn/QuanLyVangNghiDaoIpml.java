package fasttrackse.ffse1703.fbms.dao.qlvn;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Repository(value = "quanLyVangNghiDao")
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
	
	public List<ThongKeDonXinPhep> danhSachXinNghiNhap(int page) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<ThongKeDonXinPhep> cq = cb.createQuery(ThongKeDonXinPhep.class);
		Root<ThongKeDonXinPhep> root = cq.from(ThongKeDonXinPhep.class);
		cq.select(root)
				.where(cb.or(cb.equal(root.get("trangThai"), 1)));
		Query<ThongKeDonXinPhep> query = session.createQuery(cq);
		query.setFirstResult((page - 1) * 3);
		query.setMaxResults(3);
		return query.getResultList();
	}
	
	public long totalRecords() {
		Session session = this.sessionFactory.getCurrentSession();
		String queryString = "SELECT count(*) FROM ThongKeDonXinPhep WHERE trang_thai = 'Nháp'";
		Query<?> query = session.createQuery(queryString);
		return (Long) query.uniqueResult();
	}
	
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
//		int soNgayNghi = thongKeDonXinPhep.getSoNgayNghi();
//		int soNgayDaNghi = thongKeDonXinPhep.getMaNhanVien().getSoNgayDaNghi();
//		int soNgayConLai = thongKeDonXinPhep.getMaNhanVien().getSoNgayConLai();
//        int maNhanVien = thongKeDonXinPhep.getMaNhanVien().getHoSoNhanVien().getMaNhanVien();
		session.save(thongKeDonXinPhep);
//		if(soNgayConLai == 0) {
//			session.createQuery("update NgayNghi set so_ngay_da_nghi = " + (soNgayNghi + soNgayDaNghi)
//			+ "where ma_nhan_vien = " + maNhanVien ).executeUpdate();
//		} else if(soNgayNghi>soNgayConLai) {
//			session.createQuery("update NgayNghi set so_ngay_con_lai = 0, so_ngay_da_nghi = " + (soNgayNghi + soNgayDaNghi)
//					+ "where ma_nhan_vien = " + maNhanVien ).executeUpdate();
//		} else {session.createQuery("update NgayNghi set so_ngay_con_lai =  " + (soNgayConLai + soNgayDaNghi)
//				+ ",so_ngay_da_nghi =" + (soNgayDaNghi + soNgayNghi) + "where ma_nhan_vien = " + maNhanVien ).executeUpdate();
//		}
		session.createQuery("update ThongKeDonXinPhep set trangThai = '3'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	
	}

	public void createfeedback(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(thongKeDonXinPhep);
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
