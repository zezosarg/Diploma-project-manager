package diplomaProjectManager.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import diplomaProjectManager.dao.StudentDAO;

public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student findBestApplicant(List<Application> applicationList) {
//		Application bestApplication = applicationList.get(0);
//		
//		for (Application application : applicationList) {
//			if (compareApplications(application, bestApplication) == 1)
//				bestApplication = application;
//		}
//		return studentDAO.findByApplication(bestApplication.getId());
		return null;
	}

	public abstract int compareApplications(Application application1, Application application2);
	
}

//relation is unilateral so i wrote a custom query to go the opposite direction.
//during the implementations of the abstract method, 
//i created accessors in the respective classes not knowing if writing a query is the better practice
//We may have to use Optional<Student>