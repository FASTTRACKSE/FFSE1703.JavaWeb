package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tinh_trang")
public class TinhTrang {

	@Column(name="ma_tinh_trang")
	private String ma_tinh_trang;
	
	@Column(name="ten_tinh_trang")
	private String ten_tinh_trang;
	
	@Column(name="is_delete")
	private String is_delete;
	
}
