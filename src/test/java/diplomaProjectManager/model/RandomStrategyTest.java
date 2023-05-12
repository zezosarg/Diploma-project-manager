package diplomaProjectManager.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import diplomaProjectManager.dao.ApplicationDAO;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(SpringExtension.class)
@Sql({"../schema.sql", "../data.sql"})
class RandomStrategyTest {

	@Autowired
	private RandomStrategy randomStrategy;
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Test
	void test() {
		List<Application> applications = applicationDAO.findAvailableBySubjectId(1);
		Student student = randomStrategy.findBestApplicant(applications);
		System.out.println(student.getFullname());
		Assertions.assertNotNull(student);
	}

}
