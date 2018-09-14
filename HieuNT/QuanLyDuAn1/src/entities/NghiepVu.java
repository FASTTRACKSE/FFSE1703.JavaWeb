package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="nghiep_vu")
public class NghiepVu {
	@Column(name="ma_nghiep_vu")
	private String ma_nghiep_vu;
	
	@Column(name="ten_nghiep_vu")
	private String ten_nghiep_vu;
	
	@Column(name="is_delete")
	private String is_delete;

}
