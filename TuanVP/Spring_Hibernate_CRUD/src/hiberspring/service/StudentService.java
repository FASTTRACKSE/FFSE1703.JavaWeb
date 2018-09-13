package hiberspring.service;

import java.util.List;

import hiberspring.model.entity.Student;

public interface StudentService {

	public List<Student> listStudent(int start, int limit);

	public boolean checkStudent(String maSV);

	public void addStudent(Student student);

	public Student getStudentById(String maSV);

	public void updateStudent(Student student);

	public void deleteStudent(String maSV);

	public int countStudents();
}
