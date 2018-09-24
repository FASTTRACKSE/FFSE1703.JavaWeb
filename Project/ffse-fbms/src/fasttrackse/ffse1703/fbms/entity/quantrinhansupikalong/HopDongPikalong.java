package fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="thongtinhopdong")
public class HopDongPikalong {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MaHopDong")
	private int maHopDong;

	// bi-directional many-to-one association to HoSoNhanVien
	@ManyToOne
	@JoinColumn(name="MaNv")
	private HoSoNhanVienPikalong hoSoNhanVienPikalong;
	
	@ManyToOne
	@JoinColumn(name="MaLoaiHopDong")
	private LoaiHopDongPikalong loaiHopDongPikalong;
	
	
	private String ngayKiKet;
	
	
	private String ngayKetThuc;
	
	
	private int soNgayNghiTrongNam;
	
	
	private String luongThang13;

	private int trangThai;
	
	
	public HopDongPikalong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HopDongPikalong(int maHopDong, String ngayKiKet, String ngayKetThuc,
			int soNgayNghiTrongNam, String luongThang13, int trangThai) {
		super();
		this.maHopDong = maHopDong;
		this.ngayKiKet = ngayKiKet;
		this.ngayKetThuc = ngayKetThuc;
		this.soNgayNghiTrongNam = soNgayNghiTrongNam;
		this.luongThang13 = luongThang13;
		this.trangThai = trangThai;
	}

	
	
	public LoaiHopDongPikalong getLoaiHopDongPikalong() {
		return loaiHopDongPikalong;
	}

	public void setLoaiHopDongPikalong(LoaiHopDongPikalong loaiHopDongPikalong) {
		this.loaiHopDongPikalong = loaiHopDongPikalong;
	}

	public int getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(int maHopDong) {
		this.maHopDong = maHopDong;
	}
	
	public String getNgayKiKet() {
		return ngayKiKet;
	}
	public void setNgayKiKet(String ngayKiKet) {
		this.ngayKiKet = ngayKiKet;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getSoNgayNghiTrongNam() {
		return soNgayNghiTrongNam;
	}
	public void setSoNgayNghiTrongNam(int soNgayNghiTrongNam) {
		this.soNgayNghiTrongNam = soNgayNghiTrongNam;
	}
	public String getLuongThang13() {
		return luongThang13;
	}
	public void setLuongThang13(String luongThang13) {
		this.luongThang13 = luongThang13;
	}
	
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public HoSoNhanVienPikalong getHoSoNhanVienPikalong() {
		return hoSoNhanVienPikalong;
	}

	public void setHoSoNhanVienPikalong(HoSoNhanVienPikalong hoSoNhanVienPikalong) {
		this.hoSoNhanVienPikalong = hoSoNhanVienPikalong;
	}
	
}
	

