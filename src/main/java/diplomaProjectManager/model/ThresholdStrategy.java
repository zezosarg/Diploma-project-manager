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
	public Student findBestApplicant(List<Application> applications) {	// if 2 students fit the criteria, the earliest wins
		for (Application application: applications) {
			Student student = studentDAO.findByApplicationId(application.getId());
			if (student.getAvgGrade() > 7.5/*Th1*/ && student.getNumCoursesLeft() < 5/*Th2*/)	// TODO get Th from user
				return student;
		}
		return null;
	}
	
}
