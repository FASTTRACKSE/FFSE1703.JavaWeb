package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name= "qlda_vendor")
public class Vendor {
	@Id
	@Column(name = "id_vendor")
	@NotEmpty(message="Mã nhà cung cấp bắt buộc nhập")
	@Size(min = 5, max= 10, message = "Mã Nhà cung cấp từ 5 đến 10 kí tự")
	private String idVendor;
	
	@NotEmpty(message="Tên nhà cung cấp bắt buộc nhập")
	@Size(min = 5, max= 10, message = "Tên Nhà cung cấp từ 5 đến 10 kí tự")
	@Column(name="name_vendor")
	private String nameVendor;
	
	@NotEmpty(message="Vui lòng nhập địa chỉ")
	private String address;
	@Email
	@NotEmpty(message="Email cấp bắt buộc nhập")
	private String email;

	
	@NotEmpty(message="Số điện thoại  bắt buộc nhập")
	private String phone;
	
	
	
	private int status;

	public String getIdVendor() {
		return idVendor;
	}

	public void setIdVendor(String idVendor) {
		this.idVendor = idVendor;
	}

	public String getNameVendor() {
		return nameVendor;
	}

	public void setNameVendor(String nameVendor) {
		this.nameVendor = nameVendor;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
