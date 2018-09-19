package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.DanTocDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.DanTocTT;


public class DanTocServiceTTImpl implements DanTocServiceTT {
	@Autowired
	private DanTocDaoTT danTocDaoTT;

	@Override
	public List<DanTocTT> listAllDanToc() {
		// TODO Auto-generated method stub
		return this.danTocDaoTT.listAllDanToc();
	}
}
