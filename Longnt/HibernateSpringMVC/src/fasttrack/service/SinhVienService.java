package fasttrack.service;

import java.util.List;

import fasttrack.entity.Student;

public interface SinhVienService {
	public List<Student> listStudent();

	public Student findById(int id);

	public void delete(int id);

	public void update(Student student);

	public void create(Student student);
	
	public List<Student> findAllForPaging(int startPosition,int maxResult);
}
