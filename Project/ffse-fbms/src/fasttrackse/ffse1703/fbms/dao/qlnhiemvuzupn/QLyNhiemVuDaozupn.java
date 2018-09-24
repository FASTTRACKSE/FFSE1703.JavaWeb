package fasttrackse.ffse1703.fbms.dao.qlnhiemvuzupn;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuzupn.CongVienEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuzupn.TrangThaiiEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuzupn.QLyNhiemVuEntityzupn;

public class QLyNhiemVuDaozupn {
	public List<QLyNhiemVuEntityzupn> getAll();
	public void delete(QLyNhiemVuEntityzupn nv);
	public QLyNhiemVuEntityzupn findById(int id);
	public void create(QLyNhiemVuEntityzupn nv);
	public void update(QLyNhiemVuEntityzupn nv);
	public List<TrangThaiEntity> trangThai();
	public List<CongVienEntity> congViec();
}
