package diplomaProjectManager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import diplomaProjectManager.dao.ThesisDAO;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@SpringBootTest
@Sql({"../schema.sql", "../data.sql"})
class ProfessorServiceImplTest {

	@Autowired
	ProfessorServiceImpl professorServiceImpl;
	@Autowired
	ThesisDAO thesisDAO;
	
	@Test
	void testAddSubject() {
		Subject subject = professorServiceImpl.addSubject("zas");
		Assertions.assertNotNull(subject);
	}

	@Test
	void testAssignSubject() {
		professorServiceImpl.assignSubject("zas", "avgGrade", 3);
		Thesis thesis = thesisDAO.findById(2);
		Assertions.assertEquals(thesis.getStudent().getUsername(), "liakos");
	}
}
