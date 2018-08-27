package fasttrack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "sinhvien")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;

	@Column(name = "masv")
	@NotEmpty
	 String masv;
	
	@Column(name = "tensv")
	@NotEmpty
	 String tensv;
	
	@Column(name = "tuoisv")
	@NotEmpty
	 String tuoisv;
	
	@Column(name = "email")
	@NotEmpty
	 String email;
	
	@Column(name = "diachi")
	@NotEmpty
	 String diachi;
	
	@Column(name = "lop")
	@NotEmpty
	 String lop;
	
	public String avatar;
	
	public Student(String masv, String tensv, String tuoisv, String email, String diachi, String lop, String avatar) {
		super();
		this.masv = masv;
		this.tensv = tensv;
		this.tuoisv = tuoisv;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		this.avatar = avatar;
	}
	
	public Student(int id, String masv, String tensv, String tuoisv, String email, String diachi, String lop) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.tuoisv = tuoisv;
		this.email = email;
		this.diachi = diachi;
		this.lop = lop;
		
	}

	public Student(int id, String masv, String tensv, String tuoisv, String email, String diachi, String lop,String avatar) {
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

	public Student() {
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
