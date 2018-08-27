package entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


  



@Component
@Scope("prototype")
public class Student {
	
	private int code;
	
	@NotEmpty(message="Họ tên không được để trống")  
    @Size(min=3, max=20, message="Họ tên phải từ 3 đến 30 kí tự") 
	private String name;
	
	@NotEmpty(message = "Năm sinh không được để trống")
	@Min(value = 1990,message = "Năm sinh phải từ năm 1990")
	@Max(value = 2001,message = "Năm sinh phải nhỏ hơn 2001")
	private String birthYear;
	
	@NotEmpty(message= "email không được để trống")
	@Email(message= "Email không đúng định dạng")
	private String email;
	@NotEmpty(message = "Vui lòng nhập địa chỉ")
	private String address;
	@NotEmpty(message  = "Vui lòng chọn lớp")
	private String classSv;
	private MultipartFile file;
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	private String avatar;
	
	
	public Student() {
	}

	public Student(int code, String name, String birthYear, String email, String address, String classSv,String avatar) {
		super();
		this.code = code;
		this.name = name;
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
