package diplomaProjectManager.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BestApplicantStrategyFactory {

	@Autowired
	private BestAvgGradeStrategy bestAvgGradeStrategy;
	
	@Autowired
	private FewestCoursesStrategy fewestCoursesStrategy;
	
	public /*static*/ BestApplicantStrategy createStrategy(String strategy) {
		switch (strategy) {
		case "random":
			if(new Random().nextBoolean())
				return bestAvgGradeStrategy;
			return fewestCoursesStrategy;
		case "avgGrade":
			return bestAvgGradeStrategy;
		case "fewestCourses":
			return fewestCoursesStrategy;
		//case "threshold": TODO
			// code block
			//break;
		default:
			return null;
		}
	}
}
