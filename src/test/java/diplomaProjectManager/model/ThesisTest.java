package diplomaProjectManager.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ThesisTest {

	@Test
	public void testCalculateGrade() {
		Thesis thesis = new Thesis();
		thesis.setImplementationGrade(10);
		thesis.setReportGrade(10);
		thesis.setPresentationGrade(10);
		thesis.calculateGrade();
		Assertions.assertEquals(thesis.getOverallGrade(), 10);
	}

}
