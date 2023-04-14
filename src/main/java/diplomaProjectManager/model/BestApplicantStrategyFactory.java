package diplomaProjectManager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BestApplicantStrategyFactory {

	@Autowired
	private RandomStrategy randomStrategy;
	@Autowired
	private BestAvgGradeStrategy bestAvgGradeStrategy;
	@Autowired
	private FewestCoursesStrategy fewestCoursesStrategy;
	@Autowired
	private ThresholdStrategy thresholdStrategy;
	
	public BestApplicantStrategy createStrategy(String strategy) {
		switch (strategy) {
		case "random":
			return randomStrategy;
		case "avgGrade":
			return bestAvgGradeStrategy;
		case "fewestCourses":
			return fewestCoursesStrategy;
		case "threshold":
			return thresholdStrategy;
		default:
			return null;
		}
	}
}
