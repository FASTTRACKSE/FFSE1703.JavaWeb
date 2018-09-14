package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "du_an")
public class DuAn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_du_an")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String maDuAn;

	@Column(name = "ten_du_an")
	private String tenDuAn;

	@Column(name = "mo_ta_du_an")
	private String moTaDuAn;

	@Column(name = "is_delete")
	private int isDelete;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
}
