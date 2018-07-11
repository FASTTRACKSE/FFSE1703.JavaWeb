package model;

public class Student {
	private int id;
	public String firstName;
	public String txtName;
	public String txtDate;
	public String txtSex;
	public String queQuan;
	public String txtLop;
	private float lp1;
	private float lp2;
	
	
	
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

	

	public Student() {
		super();
	}

	

	public Student(int id, String firstName, String txtName, String txtDate, String txtSex, String queQuan,
			String txtLop, float lp1, float lp2) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.txtName = txtName;
		this.txtDate = txtDate;
		this.txtSex = txtSex;
		this.queQuan = queQuan;
		this.txtLop = txtLop;
		this.lp1 = lp1;
		this.lp2 = lp2;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gettxtName() {
		return txtName;
	}

	public void settxtName(String txtName) {
		this.txtName = txtName;
	}

	public String gettxtDate() {
		return txtDate;
	}

	public void settxtDate(String txtDate) {
		this.txtDate = txtDate;
	}

	public String gettxtSex() {
		return txtSex;
	}

	public void settxtSex(String txtSex) {
		this.txtSex = txtSex;
	}

	public String gettxtLop() {
		return txtLop;
	}

	public void settxtLop(String txtLop) {
		this.txtLop = txtLop;
	}
	public double getDTB() {
		return ((lp1) + (lp2)) / 2;
	}

	public String getXeploai() {
		if (this.getDTB() >= 8.5 && this.getDTB() <= 10) {
			return "Giỏi";
		} else if (this.getDTB() >= 7 && this.getDTB() <= 8.4) {
			return "Khá";
		} else if (this.getDTB() >= 5 && this.getDTB() <= 6.9) {
			return "Trung Bình";
		} else {
			return "Kém";
		}
	}
}
