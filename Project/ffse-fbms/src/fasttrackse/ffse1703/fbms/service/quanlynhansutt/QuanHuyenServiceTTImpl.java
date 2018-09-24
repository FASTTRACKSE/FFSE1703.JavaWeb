package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.QuanHuyenDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.QuanHuyenTT;
@Service
public class QuanHuyenServiceTTImpl implements QuanHuyenServiceTT {

	@Autowired
	private QuanHuyenDaoTT quanHuyenDaoTT;

	@Override
	@Transactional
	public List<QuanHuyenTT> listQuanHuyen() {

		return this.quanHuyenDaoTT.listQuanHuyen();
	}

}
