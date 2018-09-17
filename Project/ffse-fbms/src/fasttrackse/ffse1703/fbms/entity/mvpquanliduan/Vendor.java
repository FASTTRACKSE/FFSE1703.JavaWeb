package fasttrackse.ffse1703.fbms.entity.mvpquanliduan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "qlda_vendor")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vendor")
	private int idVendor;
	
	
	@Column(name="name_vendor")
	private String nameVendor;
	
	
	private String address;
	
	private String email;

	private String phone;
	
	
	
	private int status;

	public int getIdVendor() {
		return idVendor;
	}

	public void setIdVendor(int idVendor) {
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
