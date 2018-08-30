package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "SinhVien")
public class Student {
		
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "MaSv")
		@NotEmpty(message= "Mã Sinh Viên Không Được Để Trống !")
		private String maSv;
		
		@Column(name = "TenSv")
		@NotEmpty(message= "Tên Không Được Để Trống !")
		private String tenSv;

		@Column(name = "NamSinh")
		@NotEmpty(message= "Năm Sinh Không Được Để Trống !")
		private String namSinh;

		@Column(name = "Email")
		@NotEmpty(message= "Email Không Được Để Trống !")
		private String email;

		@Column(name = "DiaChi")
		@NotEmpty(message= "Địa Chỉ Không Được Để Trống !")
		private String diaChi;

		@Column(name = "LopHoc")
		@NotEmpty(message= "Lớp Học Không Được Để Trống !")
		private String lopHoc;
		
		@Column(name = "Avatar")
		public String avatar;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMaSv() {
			return maSv;
		}

		public void setMaSv(String maSv) {
			this.maSv = maSv;
		}

		public String getTenSv() {
			return tenSv;
		}

		public void setTenSv(String tenSv) {
			this.tenSv = tenSv;
		}

		public String getNamSinh() {
			return namSinh;
		}

		public void setNamSinh(String namSinh) {
			this.namSinh = namSinh;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDiaChi() {
			return diaChi;
		}

		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}

		public String getLopHoc() {
			return lopHoc;
		}

		public void setLopHoc(String lopHoc) {
			this.lopHoc = lopHoc;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		
		
}
