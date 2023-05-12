package diplomaProjectManager.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import diplomaProjectManager.model.Subject;

@SpringBootTest
@Sql({"../schema.sql", "../data.sql"})
class SubjectDAOTest {

	@Autowired
	private SubjectDAO subjectDAO;
	
	@Test
	void testFindAvailableByStudentId() {
		List<Subject> subjects = subjectDAO.findAvailableByStudentUsername("liakos");
		Assertions.assertEquals(subjects.get(1).getTitle(), "Data visualizer");
	}

}
