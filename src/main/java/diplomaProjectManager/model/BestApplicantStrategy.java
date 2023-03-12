package diplomaProjectManager.model;

import java.util.List;

public interface BestApplicantStrategy {

	Student findBestApplicant(List<Application> applicationList);
	
}