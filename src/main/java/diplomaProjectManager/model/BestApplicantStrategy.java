package diplomaProjectManager.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface BestApplicantStrategy {

	Student findBestApplicant(List<Application> applicationList);
	
}