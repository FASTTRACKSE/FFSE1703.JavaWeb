package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vai_tro_thanh_vien")
public class VaiTro {
	
	@Column(name="ma_vai_tro")
	private String ma_vai_tro;
	
	@Column(name="ten_vai_tro")
	private String ten_vai_tro;
	
	@Column(name="is_delete")
	private String is_delete;
	
}
