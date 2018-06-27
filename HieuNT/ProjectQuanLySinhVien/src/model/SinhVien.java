package model;

public class SinhVien {

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getDress() {
		return dress;
	}

	public void setDress(String dress) {
		this.dress = dress;
	}

	private String maSV;
	private String name;
	private String sex;
	private String age;
	private String cls;
	private String dress;
	private byte[] photo;
	private String imageFileName;

	public SinhVien() {
	}

	public SinhVien(String maSV, String name, String sex, String age, String cls, String dress, String imageFileName,
			byte[] photo) {
		this.maSV = maSV;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.cls = cls;
		this.dress = dress;
		this.photo = photo;
		this.imageFileName = imageFileName;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

}
