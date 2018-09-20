package fasttrackse.ffse1703.fbms.entity.qttl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ma_image",insertable = true , updatable = false)
	private String ma_image;

	@Column(name = "hinh_anh")
	private String hinh_anh;

	public String getMa_image() {
		return ma_image;
	}

	public void setMa_image(String ma_image) {
		this.ma_image = ma_image;
	}

	public String getHinh_anh() {
		return hinh_anh;
	}

	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}

}