package deqode.springpractice.backend2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringpracticeApplication.class, args);
	}

}
