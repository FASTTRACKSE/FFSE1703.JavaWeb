package quanlisinhvien;

public class SinhVien {
	private int id;
	private String masv;
	private String name;
	private String age;
	private String classe;
	private float lp1;
	private float lp2;
    
    public SinhVien() {
    }
    
    public SinhVien(int id) {
        this.id = id;
    }
    
    public SinhVien(int id, String masv, String name, String age, String classe, float lp1, float lp2) {
        this(masv,name, age, classe, lp1, lp2);
        this.id = id;
    }
    
    public SinhVien(String masv, String name, String age, String classe, float lp1, float lp2) {
    	this.masv = masv;
        this.name = name;
        this.age = age;
        this.classe = classe;
        this.lp1 = lp1;
        this.lp2 = lp2;
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
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getClasse() {
		return classe;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
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
}
