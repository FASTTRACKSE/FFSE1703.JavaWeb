package fasttrackse.ffse1703.fbms.entity.qlvn2;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "so_ngay_nghi")
public class SoNgayNghiEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;

	@Column(name = "ma_nhan_vien")
	@NotEmpty
	 Integer ma_nhan_vien;
	
	@Column(name = "so_ngay_nghi")
	@NotEmpty
	 Integer so_ngay_nghi;
	
	@Column(name = "so_ngay_con_lai")
	@NotEmpty
	 Integer so_ngay_con_lai;

	public SoNgayNghiEntity(int id, Integer ma_nhan_vien, Integer so_ngay_nghi, Integer so_ngay_con_lai) {
		super();
		this.id = id;
		this.ma_nhan_vien = ma_nhan_vien;
		this.so_ngay_nghi = so_ngay_nghi;
		this.so_ngay_con_lai = so_ngay_con_lai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getMa_nhan_vien() {
		return ma_nhan_vien;
	}

	public void setMa_nhan_vien(Integer ma_nhan_vien) {
		this.ma_nhan_vien = ma_nhan_vien;
	}

	public Integer getSo_ngay_nghi() {
		return so_ngay_nghi;
	}

	public void setSo_ngay_nghi(Integer so_ngay_nghi) {
		this.so_ngay_nghi = so_ngay_nghi;
	}

	public Integer getSo_ngay_con_lai() {
		return so_ngay_con_lai;
	}

	public void setSo_ngay_con_lai(Integer so_ngay_con_lai) {
		this.so_ngay_con_lai = so_ngay_con_lai;
	}

	@Override
	public String toString() {
		return "SoNgayNghiEntity [id=" + id + ", ma_nhan_vien=" + ma_nhan_vien + ", so_ngay_nghi=" + so_ngay_nghi
				+ ", so_ngay_con_lai=" + so_ngay_con_lai + "]";
	}
	
	
}
