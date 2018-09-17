package fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.qlynhiemvuhieulp.QLyNhiemVuDao;
import fasttrackse.ffse1703.fbms.entity.qlynhiemvuhieulp.QLyNhiemVuEntity;
import fasttrackse.ffse1703.fbms.service.qlynhiemvuhieulp.DatatableServiceCV;


@Service
public class QLyNhiemVuServiceImpl implements QLyNhiemVuService {

	@Autowired
	private QLyNhiemVuDao qLyNhiemVuDao;
	@Autowired
	private DatatableServiceCV datatableServiceCV;

	@Override
	public List<QLyNhiemVuEntity> findAll() {

		return qLyNhiemVuDao.findAll();
	}

	@Override
	public void addNew(QLyNhiemVuEntity nv) {
		qLyNhiemVuDao.addNew(nv);

	}

	@Override
	public void update(QLyNhiemVuEntity nv) {
		qLyNhiemVuDao.update(nv);

	}

	@Override
	public void delete(int ID) {
		qLyNhiemVuDao.delete(ID);
	}

	@Override
	public String toJson(QLyNhiemVuEntity nv) {

		int ID = nv.getID();
		String duAn = nv.getDuAn();
		String loaiCongviec = nv.getLoaiCongviec();
		String tenCongviec = nv.getTenCongviec();
		String moTa = nv.getMoTa();
		String tgBatdau = nv.getTgBatdau();
		String tgKetthuc = nv.getTgKetthuc();
		String nguoiDuocphancong = nv.getNguoiDuocphancong();
		String tgDukienhoanthanh = nv.getTgDukienhoanthanh();
		String loaiTrangthai = nv.getLoaiTrangthai();
		String action = "<a href='/ffse-fbms/QuanTriHeThong/chuc_danh/view/" 
				+ ID + "'><i class='fa fa-eye'></i></a>"
				+ "<a href='/ffse-fbms/QuanTriHeThong/chuc_danh/edit/"
				+ ID + "'><i class='fa fa-pencil'></i></a>"
				+ "<a href='javascript:void(0);' data-toggle='modal' data-target='#confirm-delete' data-href='/ffse-fbms/QuanTriHeThong/chuc_danh/delete/"
				+ID + "'><i class='fa fa-trash'></i></a>";

		return "[\"" + ID + "\",\"" + duAn + "\",\"" + loaiCongviec + "\",\"" + tenCongviec + "\",\"" + moTa + "\",\"" + tgBatdau + "\",\"" + tgKetthuc + "\",\"" + duAn + "\",\"" + nguoiDuocphancong + "\",\"" + tgDukienhoanthanh + "\",\"" + loaiTrangthai + "\",\"" + action + "\"]";
	}

	@Override
	public List<QLyNhiemVuEntity> findAll(int iDisplayStart, int iDisplayLength, String sql) {

		return qLyNhiemVuDao.findAll(iDisplayStart, iDisplayLength, sql);
	}

	@Override
	public String getRecordsTotal() {
		// TODO Auto-generated method stub
		return qLyNhiemVuDao.getRecordsTotal();
	}

	@Override
	public String getRecordsFiltered(String sql) {
		// TODO Auto-generated method stub
		return qLyNhiemVuDao.getRecordsFiltered(sql);
	}

	@Override
	public String getSQL(HttpServletRequest request) {
		String selectQuery = "select nv from QLyNhiemVuEntity nv ";
		String[] columnNames = { "nv.duAn", "nv.loaiCongviec", "nv.tenCongviec", "nv.moTa", "nv.tgBatDau", "nv.tgKetthuc", "nv.nguoiDuocphancong", "nv.tgDukienhoanthanh", "nv.loaiCOngviec" };
		String customCondition = "1=1";
		String sql = datatableServiceCV.getSqlQuery(selectQuery, request, columnNames, customCondition);
		return sql;
	}

	@Override
	public QLyNhiemVuEntity findByTenCongViec(String tenCongviec) {
		// TODO Auto-generated method stub
		return null;
	}

}
