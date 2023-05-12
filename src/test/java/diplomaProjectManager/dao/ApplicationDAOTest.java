package diplomaProjectManager.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import diplomaProjectManager.model.Application;

@SpringBootTest
@Sql({"../schema.sql", "../data.sql"})
class ApplicationDAOTest {

	@Autowired
	ApplicationDAO applicationDAO;
	
	@Test
	void testFindAvailableBySubjectId() {
		List<Application> applications = applicationDAO.findAvailableBySubjectId(2);
		Assertions.assertEquals(applications.size(), 0);	// Test that it excludes unavailable
		applications = applicationDAO.findAvailableBySubjectId(3);
		Assertions.assertEquals(applications.size(), 3);	// Test that that it finds available
	}

}
