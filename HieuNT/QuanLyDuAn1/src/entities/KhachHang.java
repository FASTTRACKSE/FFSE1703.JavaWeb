package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="khach_hang")
public class KhachHang {
	@Column(name="ma_khach_hang")
    private String ma_khach_hang;
	
	@Column(name="ten_khach_hang")
	private String ten_khach_hang;
	
	@Column(name="dia_chi")
	private String dia_chi;
	
	@Column(name="so_dien_thoai")
	private String so_dien_thoai;
	
	@Column(name="email")
	private String email;
	
	@Column(name="is_delete")
	private String is_delete;

}
