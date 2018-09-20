package fasttrackse.ffse1703.fbms.dao.qlynhiemvuhieulp;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaicongviecEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.LoaitrangthaiEntity;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;

public interface QLyNhiemVuDao {
	
	public List<QLyNhiemVuEntity> getAll();
	public void delete(QLyNhiemVuEntity nv);
	public QLyNhiemVuEntity findById(int id);
	public void create(QLyNhiemVuEntity nv);
	public void update(QLyNhiemVuEntity nv);
	public List<LoaitrangthaiEntity> trangThai();
	public List<LoaicongviecEntity> congViec();
}
