package diplomaProjectManager.model;

import java.util.ArrayList;
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
		List<Integer> candidateApplicationIds = new ArrayList<>();
		for (Application application : applications)
			candidateApplicationIds.add(application.getId());
		Random random = new Random();
		int randomIndex = random.nextInt(candidateApplicationIds.size());
		return studentDAO.findAvailableByApplicationId(candidateApplicationIds.get(randomIndex));
	}
	
}
