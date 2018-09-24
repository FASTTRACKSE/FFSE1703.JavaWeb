package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "qlda_program_language")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_program_language", unique = true, nullable = false)
	private int idLanguage;
	@NotEmpty
	@Column(name = "name_language", unique = true, nullable = false)	
	private String nameLanguage;
	private int status;
	public int getIdLanguage() {
		return idLanguage;
	}
	public void setIdLanguage(int idLanguage) {
		this.idLanguage = idLanguage;
	}
	public String getNameLanguage() {
		return nameLanguage;
	}
	public void setNameLanguage(String nameLanguage) {
		this.nameLanguage = nameLanguage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int i) {
		this.status = i;
	}
}
