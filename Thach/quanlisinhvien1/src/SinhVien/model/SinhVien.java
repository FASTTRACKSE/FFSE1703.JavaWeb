package SinhVien.model;

public class SinhVien {
	private int id;
	private String masv;
	private String ten;
	private String ngaysinh;
	private String quequan;
	private String gioitinh;
	private String age;
	private String lop;
	private float lp1;
	private float lp2;
    
    public SinhVien() {
    }
    
    public SinhVien(int id) {
        this.id = id;
    }
    
    public SinhVien(int id, String masv, String ten, String ngaysinh, String quequan, String gioitinh, String lop, float lp1, float lp2) {
        this(masv,ten, ngaysinh, quequan, gioitinh, lop, lp1, lp2);
        this.id = id;
    }
    
//    public SinhVien(String masv, String ten, String ngaysinh, String quequan, String gioitinh, String lop, float lp1, float lp2) {
//    	this.masv = masv;
//        this.ten = ten;
//        this.ngaysinh = ngaysinh;
//        this.quequan = quequan;
//        this.gioitinh = gioitinh;
//        this.lop = lop;
//        this.lp1 = lp1;
//        this.lp2 = lp2;
//    }
    public SinhVien(String masv, String ten, String ngaysinh, String quequan, String gioitinh, String lop, float lp1, float lp2) {
    	this.masv = masv;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.gioitinh = gioitinh;
        this.lop = lop;
        this.lp1 = lp1;
        this.lp2 = lp2;
        tinhTrungBinh();
        xepLoai();
    }
    
    public String xepLoai() {
    	if (tinhTrungBinh() <=4.9 ) {
			return "Kém";
		} else if (tinhTrungBinh() >= 5 && tinhTrungBinh() <= 6.4) {
			 return "Trung bình";
		} else if (tinhTrungBinh()>=6.5 && tinhTrungBinh()<= 7.9) {
			return "Khá";
		} else {
			return "Giỏi";
		}
	}

    public float tinhTrungBinh() {
		return (float) ((getLp1()+getLp2())/2.0);
	}

	public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTen() {
		return ten;
	}
	
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getLop() {
		return lop;
	}
	
	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public float getLp1() {
		return lp1;
	}

	public void setLp1(float lp1) {
		this.lp1 = lp1;
	}

	public float getLp2() {
		return lp2;
	}

	public void setLp2(float lp2) {
		this.lp2 = lp2;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
}
