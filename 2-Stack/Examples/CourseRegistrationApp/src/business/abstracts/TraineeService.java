package business.abstracts;

import entities.concretes.Trainee;

public interface TraineeService {
	void push(Trainee trainee);
	String pop();
	void print();
}
