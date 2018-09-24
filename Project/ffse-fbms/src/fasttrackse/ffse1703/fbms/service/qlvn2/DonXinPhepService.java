package fasttrackse.ffse1703.fbms.service.qlvn2;

import java.util.List;


import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

public interface DonXinPhepService {
	public List<DonXinPhepEntity> danhsachnhap003();
	public List<DonXinPhepEntity> danhsachchoduyet003();
	public List<DonXinPhepEntity> danhsachdaduyet003();
	public List<DonXinPhepEntity> danhsachbituchoi003();
	public void donxinphep003(DonXinPhepEntity DonXinPhepEntity);
    public List<LyDoEntity> danhSachLyDo();
	public List<TrangThaiEntity> danhSachTrangThai();
	public List<HoSoNhanVien> danhSachHoSo();
}