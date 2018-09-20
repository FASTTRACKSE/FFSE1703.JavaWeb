package fasttrackse.ffse1703.fbms.service.qlvn2;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface DonXinPhepService {
	public List<DonXinPhepEntity> danhsachnhap003();
	public List<DonXinPhepEntity> danhsachdaduyet003();
	public List<DonXinPhepEntity> danhsachchoduyet003();
	public List<DonXinPhepEntity> danhsachbituchoi003();
	public void add(DonXinPhepEntity donXinPhepEntity);
	public DonXinPhepEntity findById(int id);
}