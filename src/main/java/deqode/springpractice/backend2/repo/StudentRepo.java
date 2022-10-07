package deqode.springpractice.backend2.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import deqode.springpractice.backend2.entity.Student;

public interface StudentRepo extends MongoRepository<Student, Integer>{

}
