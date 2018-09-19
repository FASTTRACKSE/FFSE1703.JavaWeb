package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuanHuyenDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuanHuyenTT;

public class QuanHuyenServiceTTImpl implements QuanHuyenServiceTT {

	@Autowired
	private QuanHuyenDaoTT quanHuyenDaoTT;

	@Override
	public List<QuanHuyenTT> listQuanHuyen() {

		return this.quanHuyenDaoTT.listQuanHuyen();
	}

}
