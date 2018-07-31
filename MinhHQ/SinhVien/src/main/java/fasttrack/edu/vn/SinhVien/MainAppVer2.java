package fasttrack.edu.vn.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;
public class MainAppVer2 {
	public static Scanner myScanner = new Scanner(System.in);
	public static SinhVienVer2 sv = new SinhVienVer2();
	public static List<MonHoc> monHoc = new ArrayList<MonHoc>();
	public static void main(String[] args) {
		System.out.println("Nhập tên sinh viên: ");
		String Name = myScanner.nextLine();
		sv.setHoTen(Name);
		sv.setDaoTao(new DaoTaoDaiHan());
		monHoc.add(new MonToan());
		monHoc.add(new MonLy());
		monHoc.add(new MonHoa());
		sv.setMonHoc(monHoc);
		System.out.println(sv.mangSachDiHoc());		
	}
}
