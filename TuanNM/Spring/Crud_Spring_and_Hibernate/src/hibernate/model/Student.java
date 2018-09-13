package hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "studentplus")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Họ tên không được để trống")
	@Size(min = 3, max = 20, message = "Họ tên phải từ 3 đến 30 kí tự")
	@Column(name = "name")
	private String fullName;

	@NotEmpty(message = "Năm sinh không được để trống")
	@Min(value = 1990, message = "Năm sinh phải từ năm 1990")
	@Max(value = 2001, message = "Năm sinh phải nh�? hơn 2001")
	@Column(name = "birthyear")
	private String birthYear;

	@NotEmpty(message = "email không được để trống")
	@Email(message = "Email không đúng định dạng")
	@Column(name = "email")
	private String email;

	@NotEmpty(message = "Vui lòng nhập địa chỉ")
	@Column(name = "address")
	private String address;

	@NotEmpty(message = "Vui lòng ch�?n lớp")
	@Column(name = "class")
	private String classSv;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "avatar")
	private String avatar;

	public Student() {
	}

	public Student(int id, String name, String birthYear, String email, String address, String classSv, String avatar) {
		super();
		this.id = id;
		this.fullName = name;
		this.birthYear = birthYear;
		this.email = email;
		this.address = address;
		this.classSv = classSv;
		this.avatar = avatar;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClassSv() {
		return classSv;
	}

	public void setClassSv(String classSv) {
		this.classSv = classSv;
	}

}