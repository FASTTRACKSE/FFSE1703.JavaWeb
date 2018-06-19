package students;

public class Student {
	    protected int id;
	    protected String name;
	    protected String clas;
	    protected String address;
	    protected int age;
	    protected int author;
	    protected double diemLp1, diemLp2;
	    
	    public Student() {
	    }
	    
		public Student(int id) {
	        this.id = id;
	    }
	 
	    public Student(int id, String name, String clas, String address, int age, int author, double diemLp1, double diemLp2) {
	        this(name,clas,address,age,author,diemLp1,diemLp2);
	        this.id = id;
	    }
	     
	    public Student(String name, String clas, String address, int age, int author, double diemLp1, double diemLp2) {
	        this.name = name;
	        this.clas = clas;
	        this.address = address;
	        this.age = age;
	        this.author = author;
	        this.diemLp1 = diemLp1;
			this.diemLp2 = diemLp2;
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

		public String getClas() {
			return clas;
		}

		public void setClas(String clas) {
			this.clas = clas;
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

		public int getAuthor() {
			return author;
		}

		public void setAuthor(int author) {
			this.author = author;
		}
		public double getDiemLp1() {
			return diemLp1;
		}

		public void setDiemLp1(double diemLp1) {
			this.diemLp1 = diemLp1;
		}

		public double getDiemLp2() {
			return diemLp2;
		}

		public void setDiemLp2(double diemLp2) {
			this.diemLp2 = diemLp2;
		}
		public double diemTrungBinh() {
			return (diemLp1 + diemLp2) / 2;
		}
		
		public String xepLoai() {
			if(diemTrungBinh() >= 8.0) {
				return "Giỏi";
			} else if(diemTrungBinh() < 8.0 && diemTrungBinh() >= 6.5) {
				return "Khá";
			} else if(diemTrungBinh() < 6.5 && diemTrungBinh() >= 5.0 ) {
				return "Trung bình";
			} else {
				return "Yếu";
			}
		}
	 
	    
}
