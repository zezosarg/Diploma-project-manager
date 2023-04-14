package diplomaProjectManager.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import diplomaProjectManager.dao.ApplicationDAO;
import diplomaProjectManager.dao.StudentDAO;

@ExtendWith(SpringExtension.class)
class RandomStrategyTest {

	@Autowired
	RandomStrategy randomStrategy;
	@Autowired
	ApplicationDAO applicationDAO;
	@Autowired
	StudentDAO studentDAO;
	
	@Before
	public void setUp() throws Exception {
//        applicationDAO.save(new Application("Donald Duck 1", "Walt Disney", "0-14-020652-3"));
    }
	
	@Test
	void testFindBestApplicant() {
//		ArrayList<Application> applications = 
//		Student actualStudent = randomStrategy.findBestApplicant(applications);
//		assertEquals(actualStudent, expectedStudent);
	}

}
