package ducdeptrai.dao;

import java.util.List;

import ducdeptrai.model.SinhVien;

public interface SVDao {
	public void addSV(SinhVien sv);
	public void updateSV(SinhVien sv);
	public List<SinhVien> listSV(int start,int limit);
	public void deleteSV(Integer id);
	public SinhVien getSVbyId(Integer id);
	public int countSV();
	public boolean checkSV(Integer id);
}
