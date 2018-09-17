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
@Table(name= "qlda_technical")
public class Technical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_technical")
	private int idTechnical;
	
	@NotEmpty(message = "Kĩ thuật không được để trống")
	@Size(min = 5, message = "Kĩ thuật ít nhất 5 kí tự")
	@Column(name = "name_technical")
	private String nameTechnical;

	private int status;

	public int getIdTechnical() {
		return idTechnical;
	}

	public void setIdTechnical(int idTechnical) {
		this.idTechnical = idTechnical;
	}

	public String getNameTechnical() {
		return nameTechnical;
	}

	public void setNameTechnical(String nameTechnical) {
		this.nameTechnical = nameTechnical;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
