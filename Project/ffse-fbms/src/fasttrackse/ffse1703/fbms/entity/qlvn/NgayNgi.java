package fasttrackse.ffse1703.fbms.entity.qlvn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ngay_nghi")
public class NgayNgi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ngay_nghi")
    private int id;
	
	
	
	@Column(name="so_ngay_da_nghi")
	private int soNgayDaNghi;
	
	@Column(name="so_ngay_con_lai")
	private int soNgayConLai;
	
	
}
