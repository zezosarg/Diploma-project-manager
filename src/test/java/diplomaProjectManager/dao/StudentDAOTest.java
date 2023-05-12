package diplomaProjectManager.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import diplomaProjectManager.model.Student;

@SpringBootTest
@Sql({"../schema.sql", "../data.sql"})
class StudentDAOTest {

	@Autowired
	private StudentDAO studentDAO;

	@Test
	void testFindAvailableByApplicationId() {
		Student student = studentDAO.findAvailableByApplicationId(9);
		Assertions.assertNull(student);
	}

}
