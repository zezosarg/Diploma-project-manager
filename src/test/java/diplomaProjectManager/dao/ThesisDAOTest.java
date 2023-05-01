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

import diplomaProjectManager.model.Thesis;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(SpringExtension.class)
@Sql({"../schema.sql", "../data.sql"})
class ThesisDAOTest {

	@Autowired
	ThesisDAO thesisDAO;
	
	@Test
	void testFindByProfessorUsername() {
		List<Thesis> theses = thesisDAO.findByProfessorUsername("zas");
		Assertions.assertEquals("zas", theses.get(0).getProfessor().getUsername());
	}
	
	@Test
	void  testFindByStudentUsername() {
		//TODO
	}

}
