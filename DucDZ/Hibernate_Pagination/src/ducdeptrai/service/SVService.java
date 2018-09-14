package ducdeptrai.service;

import java.util.List;

import ducdeptrai.model.SinhVien;

public interface SVService {
	public void addSV(SinhVien sv);

	public void update(SinhVien sv);

	public List<SinhVien> listSV(int start, int perPage);

	public void deleteSV(Integer id);

	public SinhVien getSVbyId(Integer id);
	
	public int countSV();
	public boolean checkSV(Integer id);
}
