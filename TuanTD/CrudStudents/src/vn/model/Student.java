package vn.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class Student {
	    protected int id;
	    @NotEmpty(message= "nhập mã sinh viên")
	    protected String masv;
	    @NotEmpty(message= "nhập họ tên sinh viên")
	    protected String name;
	    protected String lop;
	    @NotNull
	    @Size(min = 1, max = 100)
	    @Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")
	    private String email;
	    protected String address;
	    @NonNull
	    @Min(13)
		@Max(110)
	    protected int age;
	    protected String author;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLop() {
			return lop;
		}
		public void setLop(String lop) {
			this.lop = lop;
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
	    
	    
}
