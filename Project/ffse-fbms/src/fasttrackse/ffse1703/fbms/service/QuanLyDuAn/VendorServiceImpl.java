package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.QuanLyDuAn.VendorDao;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Vendor;
@Service
public class VendorServiceImpl implements VendorService{
	@Autowired
	private VendorDao vendorDao;

	@Override
	@Transactional
	public List<Vendor> getAll() {
		 return this.vendorDao.getAll();
	}

	@Override
	@Transactional
	public void addNew(Vendor vd) {
		this.vendorDao.addNew(vd);
	}

	@Override
	@Transactional
	public void update(Vendor vd) {
		this.vendorDao.update(vd);
	}

	@Override
	@Transactional
	public void delete(String maVendor) {
		this.vendorDao.delete(maVendor);
	}

	@Override
	@Transactional
	public Vendor getById(String maVendor) {
		return this.vendorDao.getById(maVendor);
	}

	@Override
	@Transactional
	public void setIsDelete(String maVendor) {
		this.vendorDao.setIsDelete(maVendor);
		
	}

}
