package diplomaProjectManager.model;

import org.springframework.beans.factory.annotation.Autowired;

import diplomaProjectManager.dao.StudentDAO;

public class FewestCoursesStrategy extends TemplateStrategyAlgorithm {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public int compareApplications(Application application1, Application application2) {
		Student student1 = studentDAO.findByApplicationId(application1.getId());
		Student student2 = studentDAO.findByApplicationId(application2.getId());
		
		if (student1.getNumCoursesLeft() < student2.getNumCoursesLeft())
			return 1;
		
		return 0;
	}

}