package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "co_so_du_lieu")
public class DatabaseTeam1 {
	@Id
	
	@Column(name = "ma_database")
	private String maDatabase;

	@Column(name = "ten_database")
	private String tenDatabase;

	@Column(name = "is_delete")
	private int isDelete;

	public DatabaseTeam1() {
	}

	public String getMaDatabase() {
		return maDatabase;
	}

	public void setMaDatabase(String maDatabase) {
		this.maDatabase = maDatabase;
	}

	public String getTenDatabase() {
		return tenDatabase;
	}

	public void setTenDatabase(String tenDatabase) {
		this.tenDatabase = tenDatabase;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
}
