package diplomaProjectManager.model;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import diplomaProjectManager.dao.StudentDAO;

@Component
public class RandomStrategy implements BestApplicantStrategy{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student findBestApplicant(List<Application> applications) {
		Random random = new Random();
		int index = random.nextInt(applications.size());
		return studentDAO.findByApplicationId(index);
	}
	
}
