package ducdeptrai.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "sinhvien_hibernate")
public class SinhVien {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ho_ten")
	private String ho_ten;
	
	@Column(name = "nam_sinh")
	private String nam_sinh;
	
	@Column(name="email")
	private String email;
	
	@Column(name="avatar")
	private String avatar;
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public String getNam_sinh() {
		return nam_sinh;
	}

	public void setNam_sinh(String nam_sinh) {
		this.nam_sinh = nam_sinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SinhVien(Integer id, String ho_ten, String nam_sinh, String email, String avatar) {
		super();
		this.id = id;
		this.ho_ten = ho_ten;
		this.nam_sinh = nam_sinh;
		this.email = email;
		this.avatar = avatar;
	}

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}
}
