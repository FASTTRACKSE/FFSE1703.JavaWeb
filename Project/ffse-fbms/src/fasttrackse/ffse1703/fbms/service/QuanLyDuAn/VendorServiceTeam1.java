package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.VendorTeam1;

public interface VendorServiceTeam1 {

	public List<VendorTeam1> getAll();

	public void delete(String maVendor);

	public void addNew(VendorTeam1 vd);

	public VendorTeam1 getById(String maVendor);

	public void update(VendorTeam1 vd);

	public void setIsDelete(String maVendor);
}
