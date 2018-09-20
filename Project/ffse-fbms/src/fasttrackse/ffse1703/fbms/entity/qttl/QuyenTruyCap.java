package fasttrackse.ffse1703.fbms.entity.qttl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quyen_truy_cap")
public class QuyenTruyCap implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@OneToMany(mappedBy="ma_truy_cap")
	private List<Document> Document;
	public List<Document> getDocument() {
		return Document;
	}
	public void setDocument(List<Document> document) {
		Document = document;
	}
	
	
	@Column(name = "quyen_truy_cap")
	private String quyen_truy_cap;

	@Column(name="ma_truy_cap")
	private String ma_truy_cap;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuyen_truy_cap() {
		return quyen_truy_cap;
	}

	public void setQuyen_truy_cap(String quyen_truy_cap) {
		this.quyen_truy_cap = quyen_truy_cap;
	}

}