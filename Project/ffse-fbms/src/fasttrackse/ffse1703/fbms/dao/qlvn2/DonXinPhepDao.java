package fasttrackse.ffse1703.fbms.dao.qlvn2;

import java.util.List;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface DonXinPhepDao {
	public List<DonXinPhepEntity> danhsachnhap003();
	public List<DonXinPhepEntity> danhsachdaduyet003();
	public List<DonXinPhepEntity> danhsachbituchoi003();
	public List<DonXinPhepEntity> danhsachchoduyet003();
	public void donxinphep003(DonXinPhepEntity DonXinPhepEntity);
//	public List<LyDoEntity> danhsachlyDo();
//    public List<TrangThaiEntity> danhsachTrangThai();
//    public List<HoSoNhanVien> danhsachHoSo();
	public DonXinPhepEntity findById(int id);
}
