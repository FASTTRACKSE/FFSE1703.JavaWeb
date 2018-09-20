package fasttrackse.ffse1703.fbms.entity.qttl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tai_lieu")
public class Document {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ten_tai_lieu")
	private String ten_tai_lieu;
	

	@Column(name = "file")
	private String file;
	
	@Column(name = "mo_ta")
	private String mo_ta;

	@Column(name = "ghi_chu")
	private String ghi_chu;
	
	@ManyToOne
	@JoinColumn(name = "ma_truy_cap", referencedColumnName = "ma_truy_cap")
	private QuyenTruyCap ma_truy_cap;

	public QuyenTruyCap getMa_truy_cap() {
		return ma_truy_cap;
	}

	public void setMa_truy_cap(QuyenTruyCap ma_truy_cap) {
		this.ma_truy_cap = ma_truy_cap;
	}

	@ManyToOne
	@JoinColumn(name = "ma_danh_muc", referencedColumnName = "ma_danh_muc")
	private Category ma_danh_muc;

	public Category getMa_danh_muc() {
		return ma_danh_muc;
	}

	public void setMa_danh_muc(Category ma_danh_muc) {
		this.ma_danh_muc = ma_danh_muc;
	}

	@ManyToOne
	@JoinColumn(name = "ma_trang_thai", referencedColumnName = "ma_trang_thai")
	private Status ma_trang_thai;

	public Status getMa_trang_thai() {
		return ma_trang_thai;
	}

	public void setMa_trang_thai(Status ma_trang_thai) {
		this.ma_trang_thai = ma_trang_thai;
	}

	@ManyToOne
	@JoinColumn(name = "ma_image", referencedColumnName = "ma_image")
	private Image ma_image;

	public Image getMa_image() {
		return ma_image;
	}

	public void setMa_image(Image ma_image) {
		this.ma_image = ma_image;
	}

	// getter and setter
	 
	
	public String getMo_ta() {
		return mo_ta;
	}
	
	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen_tai_lieu() {
		return ten_tai_lieu;
	}

	public void setTen_tai_lieu(String ten_tai_lieu) {
		this.ten_tai_lieu = ten_tai_lieu;
	}
	
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}



	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

}