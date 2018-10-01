package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Projects;
import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Roles;

@Entity
@Table(name = "qlda_role_assignment")
public class NhiemVuTT {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_project")
	private Projects projects;
	@ManyToOne
	@JoinColumn(name = "id_employee")
	private HoSoNhanVienTT hoSoNhanVienTT;

	@ManyToOne
	@JoinColumn(name = "id_role")
	private Roles roles;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public HoSoNhanVienTT getHoSoNhanVienTT() {
		return hoSoNhanVienTT;
	}

	public void setHoSoNhanVienTT(HoSoNhanVienTT hoSoNhanVienTT) {
		this.hoSoNhanVienTT = hoSoNhanVienTT;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

}
