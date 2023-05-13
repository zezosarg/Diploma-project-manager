package diplomaProjectManager.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import diplomaProjectManager.dao.ApplicationDAO;

@SpringBootTest
@Sql({"../schema.sql", "../data.sql"})
class RandomStrategyTest {

	@Autowired
	private RandomStrategy randomStrategy;
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Test
	void testRandomStrategy() {
		List<Application> applications = applicationDAO.findAvailableBySubjectId(1);
		Student student = randomStrategy.findBestApplicant(applications);
		Assertions.assertNotNull(student);
	}

}
