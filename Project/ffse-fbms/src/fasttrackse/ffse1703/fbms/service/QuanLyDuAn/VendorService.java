package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.Vendor;

public interface VendorService {

	public List<Vendor> getAll();

	public void delete(String maVendor);

	public void addNew(Vendor vd);

	public Vendor getById(String maVendor);

	public void update(Vendor vd);

	public void setIsDelete(String maVendor);
}
