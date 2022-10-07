package deqode.springpractice.backend2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deqode.springpractice.backend2.entity.Student;
import deqode.springpractice.backend2.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studRepo;

	public Student addStudent(Student stud) {

		return studRepo.save(stud);
	}

	public List<Student> getStudent() {
		
		return studRepo.findAll();
	}
	
	
}
