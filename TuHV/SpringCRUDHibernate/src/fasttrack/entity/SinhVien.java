package fasttrack.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "emp99")
public class SinhVien {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;

	@Column(name = "maSV")
	@NotEmpty
	 String masv;
	
	@Column(name = "tenSV")
	@NotEmpty
	 String tensv;
	
	@Column(name = "namSinh")
	@NotEmpty
	 String tuoisv;
	
	@Column(name = "email")
	@NotEmpty
	 String email;
	
	@Column(name = "diaChi")
	@NotEmpty
	 String diachi;
	
	@Column(name = "lopHoc")
	@NotEmpty
	 String lop;
	
	public String avatar;
	
	
	public SinhVien(String masv, String tensv, String tuoisv, String email, String diachi, String lop, String avatar) {
		super();
		this.masv = masv;
		this.tensv = tensv;
		this.tuoisv = tuoisv;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		this.avatar = avatar;
	}
	
	public SinhVien(int id, String masv, String tensv, String tuoisv, String email, String diachi, String lop) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.tuoisv = tuoisv;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		
	}

	public SinhVien(int id, String masv, String tensv, String tuoisv, String email, String diachi, String lop,String avatar) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.tuoisv = tuoisv;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		this.avatar = avatar;
	}

	public SinhVien() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public String getTuoisv() {
		return tuoisv;
	}

	public void setTuoisv(String tuoisv) {
		this.tuoisv = tuoisv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}
	
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ",masv=" + masv + ", tensv=" + tensv + ", tuoisv ="+ tuoisv +",email ="+ email +","
				+ ", diachi=" + diachi + ",lop=" + lop + ", avatar="+ avatar +"";
	}
}