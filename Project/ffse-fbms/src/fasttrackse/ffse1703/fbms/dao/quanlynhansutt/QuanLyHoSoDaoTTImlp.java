package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;

@Repository
public class QuanLyHoSoDaoTTImlp implements QuanLyHoSoDaoTT {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVienTT> getAllHoSo() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVienTT> listHoSo = session.createQuery("from HoSoNhanVienTT").getResultList();
		return listHoSo;
	}

	@Override
	public List<HoSoNhanVienTT> getAllHoSo(int iDisplayStart, int iDisplayLength, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HoSoNhanVienTT getHoSoNhanVienById(int maNhanVien) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HoSoNhanVienTT> getHoSoByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHoSoNhanVien(HoSoNhanVienTT hsnv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateHoSoNhanVien(HoSoNhanVienTT hsnv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteHoSoNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub

	}

	@Override
	public HoSoNhanVienTT findByMaHopDong(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HoSoNhanVienTT.class, maNhanVien);
	}


}
