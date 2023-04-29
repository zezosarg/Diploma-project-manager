package diplomaProjectManager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import diplomaProjectManager.dao.ApplicationDAO;
import diplomaProjectManager.model.Application;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(SpringExtension.class)
@Sql({"../schema.sql", "../data.sql"})
class StudentServiceImplTest {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	@Autowired
	ApplicationDAO applicationDAO;
	
	@Test
	void testApplyToSubject() {
		studentServiceImpl.applyToSubject("liakos", 1);
		Application createdApplication = applicationDAO.findById(9);
		Assertions.assertNotNull(createdApplication);
	}

}
