package diplomaProjectManager.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import diplomaProjectManager.dao.StudentDAO;

@Component
public class ThresholdStrategy implements BestApplicantStrategy{
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student findBestApplicant(List<Application> applications, int...threshold) {
		for (Application application: applications) {
			Student student = studentDAO.findAvailableByApplicationId(application.getId());
			if (student.getAvgGrade() > threshold[0] && student.getNumCoursesLeft() < threshold[1])
				return student;
		}
		return null;
	}
	
}	// if >1 students fit the criteria, the earliest wins
