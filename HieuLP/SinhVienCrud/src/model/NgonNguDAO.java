package model;

import java.util.HashMap;
import java.util.Map;

public class NgonNguDAO {
	public Map<String,String>ThailandLanguage(){
		Map<String,String> map= new HashMap<>();
		map.put("Login.tieude","การจัดการนักเรียน");
		map.put("Login.add","เพิ่มผู้เรียน    ");
		map.put("Login.dssv","รายชื่อนักเรียน");
		map.put("Login.masv","รหัสนักเรียน");
		map.put("Login.ten","ชื่อ");
		map.put("Login.gioitinh","เพศ	");
		map.put("Login.tuoi","อายุ");
		map.put("Login.lop","การเรียน	");
		map.put("Login.diachi","ที่อยู่");
		map.put("Login.action","การกระทำ");
		return map;
		
	}
	public Map<String,String>VietNamLanguage(){
		Map<String,String> map= new HashMap<>();
		map.put("Login.tieude","QUẢN LÝ SINH VIÊN");
		map.put("Login.add","ADD SINH VIÊN");
		map.put("Login.dssv","Danh sách sinh viên");
		map.put("Login.masv","Mã sinh viên");
		map.put("Login.ten","Tên");
		map.put("Login.gioitinh","Giới tính	");
		map.put("Login.tuoi","Tuổi");
		map.put("Login.lop","Lớp");
		map.put("Login.diachi","Địa chỉ");
		map.put("Login.action","Action");
		return map;
		
	}

}
