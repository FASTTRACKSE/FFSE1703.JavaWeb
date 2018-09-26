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
		List<ThongKeDonXinPhep> list = session.createQuery("from ThongKeDonXinPhep where trangThai = '1'").getResultList();
		return list;
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

	
	public void createWait(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '2'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
		
	}

	public void createBrowse(ThongKeDonXinPhep thongKeDonXinPhep) {
		Session session = this.sessionFactory.getCurrentSession();
		 session.save(thongKeDonXinPhep);
		session.createQuery("update ThongKeDonXinPhep set trangThai = '3'  where id =" + thongKeDonXinPhep.getId()).executeUpdate();
//		int soNgayNghi = thongKeDonXinPhep.getSoNgayNghi();
//		int soNgayDaNghi = thongKeDonXinPhep.getThongTinHoSoNhanVien().getSoNgayDaNghi();
//		int ngayConLai = thongKeDonXinPhep.getThongTinHoSoNhanVien().getSoNgayConLai();
//        int maNhanVien = thongKeDonXinPhep.getThongTinHoSoNhanVien().getMaNhanVien();
//        if (ngayConLai == 0) {
//			session.createQuery("update ThongTinHoSoNhanVien set soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi)
//					+ "where maNhanVien = " + maNhanVien).executeUpdate();
//		} else if (soNgayNghi > ngayConLai) {
//			session.createQuery("update ThongTinHoSoNhanVien set soNgayConLai = 0,soNgayDaNghi = "
//					+ (soNgayDaNghi + soNgayNghi) + "where maNhanVien = " + maNhanVien).executeUpdate();
//		} else {
//			session.createQuery("update ThongTinHoSoNhanVien set soNgayConLai = " + (ngayConLai - soNgayNghi)
//					+ ",soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi) + "where maNhanVien = " + maNhanVien)
//					.executeUpdate();
//		}

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
