package fasttrackse.ffse1703.fbms.dao.qlvn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fasttrackse.ffse1703.fbms.entity.qlvn.NgayNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;

@Repository(value = "quanLyNgayNghiDao")
@Transactional(rollbackFor = Exception.class)
public class QuanLyNgayNghiDaoIpml implements QuanLyNgayNghiDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<NgayNghi> danhSachNgayNghi() {
		Session session = sessionFactory.getCurrentSession();
		List<NgayNghi> list = session.createQuery("from NgayNghi").getResultList();
		return list;
	}

	public NgayNghi findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		NgayNghi list = (NgayNghi) session.get(NgayNghi.class, id);
		return list;
	}

	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
		
	}

}
