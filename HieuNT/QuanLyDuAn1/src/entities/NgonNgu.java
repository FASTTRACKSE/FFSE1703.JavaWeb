package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ngon_ngu")
public class NgonNgu {
	@Column(name="ma_ngon_ngu")
	private String ma_ngon_ngu;
	
	@Column(name="ten_ngon_ngu")
	private String ten_ngon_ngu;
	
	@Column(name="is_delete")
	private String is_delete;
	

}
