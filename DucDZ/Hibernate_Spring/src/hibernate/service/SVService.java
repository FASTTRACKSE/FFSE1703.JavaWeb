package hibernate.service;

import java.util.List;

import hibernate.model.SinhVien;

public interface SVService {
	public void addSV(SinhVien sv);
	public void updateSV(SinhVien sv);
	public List<SinhVien> listSV();
	public void deleteSV(int id);
	public SinhVien getSVbyID(int id);
}
