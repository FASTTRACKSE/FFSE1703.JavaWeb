package javaweb.modle.bean;

public class Student {
	 private String code; 
	 private String name;
	 private String age;
	 private String classSt;
	 private String sex;
	 private String country;
	 private Double lp1;
	 private Double lp2;
	 private Double dtb;
	 private String xepLoai;
	 
	 
	 public  Student() {
		 
	 }
	 public Student(String code,String name, String age, String classSt,String sex,String country) {
		 this.code = code;
		 this.name = name;
		 this.age = age;
		 this.classSt= classSt;
		 this.sex = sex;
		 this.country = country;
	}
	 public Student(String code,String name, String age, String classSt,String sex,String country,
			 Double lp1,Double lp2) {
		 this.code = code;
		 this.name = name;
		 this.age = age;
		 this.classSt= classSt;
		 this.sex = sex;
		 this.country = country;
		 this.lp1 = lp1;
		 this.lp2 = lp2;
	}
	public Double getLp1() {
		return lp1;
	}
	public void setLp1(Double lp1) {
		this.lp1 = lp1;
	}
	public Double getLp2() {
		return lp2;
	}
	public void setLp2(Double lp2) {
		this.lp2 = lp2;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getClassSt() {
		return classSt;
	}
	public void setClassSt(String classSt) {
		this.classSt = classSt;
	}
	public Double getDTB() {
		return (lp1+lp2)/2;
	}
	public String getXepLoai() {
		if (getDTB() >= 8.0 && getDTB()<= 10) {
			return  xepLoai = "Gi�?i";
		} else if (getDTB() >= 6.5 && getDTB() < 8.0) {
			return  xepLoai = "khá";
		} else if (getDTB() < 6.5 && getDTB() >= 5) {
			return  xepLoai = "Trung BÌnh";
		} else if (getDTB() < 5 && getDTB() > 0) {
			return  xepLoai = "Yếu";
		} else {
			return  xepLoai = "chưa đạt";
		}
	}	
}
