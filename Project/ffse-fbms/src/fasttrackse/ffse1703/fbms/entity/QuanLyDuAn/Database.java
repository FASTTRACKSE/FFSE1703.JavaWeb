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

<<<<<<< HEAD
	public Database() {
	}

=======
	public String getMa_database() {
		return maDatabase;
	}

	public void setMa_database(String ma_database) {
		this.maDatabase = ma_database;
	}
>>>>>>> 938fc3668bf0e4f29562d8597fcf0293865be62a

	public String getTen_database() {
		return tenDatabase;
	}

	public void setTen_database(String ten_database) {
		this.tenDatabase = ten_database;
	}

	public int getIs_delete() {
		return isDelete;
	}

<<<<<<< HEAD
	public String getMaDatabase() {
		return maDatabase;
	}


	public void setMaDatabase(String maDatabase) {
		this.maDatabase = maDatabase;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
=======
	public void setIs_delete(int is_delete) {
		this.isDelete = is_delete;
>>>>>>> 938fc3668bf0e4f29562d8597fcf0293865be62a
	}

}
