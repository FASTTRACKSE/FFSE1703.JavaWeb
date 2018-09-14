package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "co_so_du_lieu")
public class Database {
	@Column(name="ma_database")
	private String ma_database;
	
	@Column(name="ten_database")
	private String ten_database;
	
	@Column(name="is_delete")
	private int is_delete;

	

}
