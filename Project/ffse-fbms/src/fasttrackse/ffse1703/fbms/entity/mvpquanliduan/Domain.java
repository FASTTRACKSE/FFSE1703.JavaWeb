package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "qlda_domain")
public class Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_domain")
	private int idDomain;

	@NotEmpty(message = "Nghiệp vụ không được để trống!!")
	@Size(min = 5, message = "nghiệp vụ ít nhất 5 kí tự")
	@Column(name = "name_domain")
	private String nameDomain;

	private int status;

	public int getIdDomain() {
		return idDomain;
	}

	public void setIdDomain(int idDomain) {
		this.idDomain = idDomain;
	}

	public String getNameDomain() {
		return nameDomain;
	}

	public void setNameDomain(String nameDomain) {
		this.nameDomain = nameDomain;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
