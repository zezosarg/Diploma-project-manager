package diplomaProjectManager.model;

import java.util.Random;

public class BestApplicantStrategyFactory {

	public static BestApplicantStrategy createStrategy(String strategy) {
		switch (strategy) {
		case "random":
			if(new Random().nextBoolean())
				return new BestAvgGradeStrategy();
			return new FewestCoursesStrategy();
		case "avgGrade":
			return new BestAvgGradeStrategy();
		case "fewestCourses":
			return new FewestCoursesStrategy();
		//case "threshold": TODO
			// code block
			//break;
		default:
			return null;
		}
	}
}
