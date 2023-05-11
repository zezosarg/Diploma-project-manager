package diplomaProjectManager.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import diplomaProjectManager.model.Subject;

//@TestPropertySource(locations = "classpath:application.properties")
//@ExtendWith(SpringExtension.class)
@SpringBootTest
@Sql({"../schema.sql", "../data.sql"})
class SubjectDAOTest {

	@Autowired
	SubjectDAO subjectDAO;
	
	@Test
	void testFindAvailableByStudentId() {
		List<Subject> subjects = subjectDAO.findAvailableByStudentUsername("liakos");
		Assertions.assertEquals(subjects.get(1).getTitle(), "Data visualizer");
	}

}
