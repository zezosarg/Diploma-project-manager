package diplomaProjectManager.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import diplomaProjectManager.dao.StudentDAO;

@Component
public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student findBestApplicant(List<Application> applications) {
		Application bestApplication = applications.get(0);
		for (Application application : applications) {
			if (compareApplications(application, bestApplication) == 1)
				bestApplication = application;
		}
		return studentDAO.findByApplicationId(bestApplication.getId());
	}

	public abstract int compareApplications(Application application1, Application application2);
	
}
