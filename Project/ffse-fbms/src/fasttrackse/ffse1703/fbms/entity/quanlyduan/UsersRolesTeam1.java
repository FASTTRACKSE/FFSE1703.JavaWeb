package fasttrackse.ffse1703.fbms.entity.quanlyduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UsersRolesTeam1 {

	@Column(name = "ma_role")
	private Integer maRole;
	@Column(name = "ma_tai_khoan")
	private Integer maTaiKhoan;

	public Integer getMaRole() {
		return maRole;
	}

	public void setMaRole(Integer maRole) {
		this.maRole = maRole;
	}

	public Integer getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(Integer maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

}
