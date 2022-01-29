package business.abstracts;

import entities.concretes.StudentNode;
	
public interface StudentService {
	void insertFirst(StudentNode student);
	void insertLast(StudentNode student);
	void remove(int number);
	void search(int number);
	int numberOfStudents();
	void theBestStudent();
	void print();
}
