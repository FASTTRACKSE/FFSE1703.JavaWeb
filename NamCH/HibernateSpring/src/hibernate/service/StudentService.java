package hibernate.service;

import java.util.List;

import hibernate.entity.Student;

public interface StudentService {
	public void addStudent(Student std);
	public void updateStudent(Student std);
	public List<Student> listStudent(int start,int end);
	public Student getStudentById(int id);
	public void removeStudent(int id);
	public Long countStudent();
}
