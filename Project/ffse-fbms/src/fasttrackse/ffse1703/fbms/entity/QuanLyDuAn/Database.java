package fasttrackse.ffse1703.fbms.entity.QuanLyDuAn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "co_so_du_lieu")
public class Database {
	@Id
	@Column(name = "ma_database")
	private String maDatabase;

	@Column(name = "ten_database")
	private String tenDatabase;

	@Column(name = "is_delete")
	private int isDelete;

	public String getMa_database() {
		return maDatabase;
	}

	public void setMa_database(String ma_database) {
		this.maDatabase = ma_database;
	}

	public String getTen_database() {
		return tenDatabase;
	}

	public void setTen_database(String ten_database) {
		this.tenDatabase = ten_database;
	}

	public int getIs_delete() {
		return isDelete;
	}

	public void setIs_delete(int is_delete) {
		this.isDelete = is_delete;
	}

}
