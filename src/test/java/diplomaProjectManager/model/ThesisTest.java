package diplomaProjectManager.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ThesisTest {

	@Test
	public void testCalculateGrade() {
		Thesis thesis = new Thesis();
		thesis.setImplementationGrade((float)10);
		thesis.setReportGrade((float)10);
		thesis.setPresentationGrade((float)10);
		thesis.calculateGrade();
		Assertions.assertEquals(thesis.getOverallGrade(), 10);
	}

}
