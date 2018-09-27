package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.ThongTinGiaDinhDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ThongTinGiaDinhTT;

@Service
public class ThongTinGiaDinhServiceTTImpl implements ThongTinGiaDinhServiceTT {
	
	@Autowired
	private ThongTinGiaDinhDaoTT thongTinGiaDinhDaoTT;

	@Override
	public void addGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGiaDinh(ThongTinGiaDinhTT p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ThongTinGiaDinhTT getGiaDinhById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeGiaDinh(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<ThongTinGiaDinhTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		return this.thongTinGiaDinhDaoTT.viewOne(maNhanVien);
	}

	@Override
	public int checkQuanHe(String quanHe, int maNhanVien) {
		// TODO Auto-generated method stub
		return 0;
	}

}
