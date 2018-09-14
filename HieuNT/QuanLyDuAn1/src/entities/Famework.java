package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="framework")
public class Famework {
	
	@Column(name="ma_framework")
	private String maFramework;
	
	@Column(name="ten_framework")
	private String tenFramework;
	
	@Column(name="is_delete")
	private int isDelete;
}
