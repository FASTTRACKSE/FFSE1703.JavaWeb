package hibernate.service;

import java.util.List;

import hibernate.entity.Student;

public interface StudentService {

	public void addStudent(Student sv);
	public void updateStudent(Student sv);
	public List<Student> listStudent();
	public Student getStudentById(int id);
	public void removeStudent(int id);
	public List<Student> listStudent(int start, int limit);
	public int countStudents();

}
