package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "doi_tac")
public class DoiTac {
	
	
	@Column(name="ma_doi_tac")
    private String ma_doi_tac;
	
	@Column(name="ten_doi_tac")
	private String ten_doi_tac;
	
	@Column(name="dia_chi")
	private String dia_chi;
	
	@Column(name="so_dien_thoai")
	private String so_dien_thoai;
	
	@Column(name="email")
	private String email;
	
	@Column(name="is_delete")
	private String is_delete;

}
