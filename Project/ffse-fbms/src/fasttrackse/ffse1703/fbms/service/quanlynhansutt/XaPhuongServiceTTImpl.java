package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.XaPhuongDaoTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.XaPhuongTT;

public class XaPhuongServiceTTImpl implements XaPhuongServiceTT{
	@Autowired
	private XaPhuongDaoTT xaPhuongDaoTT;

	@Override
	public List<XaPhuongTT> getAllXaPhuong() {
		// TODO Auto-generated method stub
		return this.xaPhuongDaoTT.listXaPhuong();
	}
}
