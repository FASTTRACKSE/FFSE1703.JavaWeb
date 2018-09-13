package mvc.service;

import java.util.List;

import mvc.entity.Student;

public interface SinhVienService {

	public void addSV(Student p);

	public void updateSV(Student p);

//	public List<Student> getAll();

	public Student getSinhVienByID(int id);

	public void deleteSinhVien(int id);

	public List<Student> findAll(Integer offset, Integer maxResult);

	public int count();
}
