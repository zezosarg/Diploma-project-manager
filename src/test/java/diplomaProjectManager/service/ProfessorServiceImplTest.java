package diplomaProjectManager.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import diplomaProjectManager.dao.ThesisDAO;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(SpringExtension.class)
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
		professorServiceImpl.assignSubject("zas", "avgGrade", 1);
		Thesis thesis = thesisDAO.findById(2);
		Assertions.assertEquals(thesis.getStudent().getUsername(), "ofwtios");
	}
}
