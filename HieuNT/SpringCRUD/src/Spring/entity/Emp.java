package Spring.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;
public class Emp {
	private int id;
	@Length(min = 5, max = 10)
	@NotBlank(message = "Phải nhập thông tin")
	private String name;
	
	@NotBlank(message = "Phải nhập thông tin")
	private String address;
	
	@Email(message = "Email chưa đúng")
	@NotBlank(message = "Phải nhập thông tin")
	private String email;

    private String nameFile;
	
    private MultipartFile myFile;

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public MultipartFile getMyFile() {
		return myFile;
	}

	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}

	public Emp() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
