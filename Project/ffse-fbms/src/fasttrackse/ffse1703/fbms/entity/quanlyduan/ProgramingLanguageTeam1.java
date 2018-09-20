package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ngon_ngu")
public class ProgramingLanguageTeam1 {
	@Id
	@NotEmpty
	@Column(name = "ma_ngon_ngu")
	 String maNn;
	
	@Column(name = "ten_ngon_ngu")
	@NotEmpty
	 String tenNn;
	
	@Column(name = "is_delete")
	 int isDelete;

	public String getMaNn() {
		return maNn;
	}

	public void setMaNn(String maNn) {
		this.maNn = maNn;
	}

	public String getTenNn() {
		return tenNn;
	}

	public void setTenNn(String tenNn) {
		this.tenNn = tenNn;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
}
