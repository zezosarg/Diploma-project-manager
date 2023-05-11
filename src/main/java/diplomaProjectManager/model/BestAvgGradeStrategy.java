package diplomaProjectManager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import diplomaProjectManager.dao.StudentDAO;

@Component
public class BestAvgGradeStrategy extends TemplateStrategyAlgorithm {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public int compareApplications(Application application1, Application application2) {
		Student student1 = studentDAO.findAvailableByApplicationId(application1.getId());
		Student student2 = studentDAO.findAvailableByApplicationId(application2.getId());
		if (student1.getAvgGrade() > student2.getAvgGrade())
			return 1;		
		return 0;
	}
	
}
