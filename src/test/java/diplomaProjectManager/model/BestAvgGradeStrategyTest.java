package diplomaProjectManager.model;

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
class BestAvgGradeStrategyTest {

	@Autowired
	private BestAvgGradeStrategy bestAvgGradeStrategy;
	@Autowired
	private ApplicationDAO applicationDAO;
	
	@Test
	void testBestAvgGradeStrategy() {
		Application application1 = applicationDAO.findById(1);
		Application application2 = applicationDAO.findById(4);
		int result = bestAvgGradeStrategy.compareApplications(application1, application2);
		Assertions.assertEquals(result, 0);
	}

}
