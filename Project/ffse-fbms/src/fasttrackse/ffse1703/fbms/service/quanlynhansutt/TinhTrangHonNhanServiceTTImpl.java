package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.TinhTrangHonNhanDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.TinhTrangHonNhanTT;

public class TinhTrangHonNhanServiceTTImpl implements TinhTrangHonNhanServiceTT {
	@Autowired
	private TinhTrangHonNhanDaoTT tinhTrangHonNhanDaoTT;

	@Override
	public List<TinhTrangHonNhanTT> getAllTinhTrangHonNhan() {
		// TODO Auto-generated method stub
		return this.tinhTrangHonNhanDaoTT.getAllTinhTrangHonNhan();
	}

}
