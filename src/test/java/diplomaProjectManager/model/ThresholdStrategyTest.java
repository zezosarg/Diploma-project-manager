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
class ThresholdStrategyTest {

	@Autowired
	private ThresholdStrategy thresholdStrategy;
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Test
	void testThresholdStrategy() {
		List<Application> applications = applicationDAO.findAvailableBySubjectId(3);
		Student student = thresholdStrategy.findBestApplicant(applications, 8, 14);
		Assertions.assertEquals(student.getUsername(), "liakos");
	}

}
