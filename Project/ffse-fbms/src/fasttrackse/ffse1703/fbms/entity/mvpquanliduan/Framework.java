package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qlda_framework")
public class Framework {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_framework", unique = true, nullable = false)
	private int idFrame;
	@Column(name="name_framework",unique = true, nullable=false)	
	private String nameFramework;
	@Column(name="id_program_language",unique = true, nullable=false)
	private int idProgramLanguage;
	private int status;
	

	public int getIdFrame() {
		return idFrame;
	}

	public void setIdFrame(int idFrame) {
		this.idFrame = idFrame;
	}

	public String getNameFramework() {
		return nameFramework;
	}

	public void setNameFramework(String nameFramework) {
		this.nameFramework = nameFramework;
	}

	public int getIdProgramLanguage() {
		return idProgramLanguage;
	}

	public void setIdProgramLanguage(int idProgramLanguage) {
		this.idProgramLanguage = idProgramLanguage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
