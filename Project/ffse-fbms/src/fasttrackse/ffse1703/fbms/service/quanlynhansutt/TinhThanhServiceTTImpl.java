package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.TinhThanhDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.TinhThanhTT;

public class TinhThanhServiceTTImpl implements TinhThanhServiceTT {
	@Autowired
	private TinhThanhDaoTT tinhThanhDaoTT;

	@Override
	public List<TinhThanhTT> getAllTinhThanh() {
		// TODO Auto-generated method stub
		return this.tinhThanhDaoTT.listTinhThanh();
	}
}
