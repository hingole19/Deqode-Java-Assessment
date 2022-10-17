package deqode.assessment.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication
@EnableMongoRepositories
public class JavaassessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaassessmentApplication.class, args);
	}
}
