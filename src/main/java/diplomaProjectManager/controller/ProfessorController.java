package diplomaProjectManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import diplomaProjectManager.dao.StudentDAO;
import diplomaProjectManager.dao.SubjectDAO;
import diplomaProjectManager.dao.ThesisDAO;
import diplomaProjectManager.model.Application;
import diplomaProjectManager.model.BestApplicantStrategy;
import diplomaProjectManager.model.BestApplicantStrategyFactory;
import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;
import diplomaProjectManager.service.ProfessorService;
import diplomaProjectManager.service.SubjectService;
import diplomaProjectManager.service.UserService;

@Controller
public class ProfessorController {
	
//	private String currentPrincipalName; //saving username here works but is it safe?
	@Autowired
	private UserService userService;
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SubjectDAO subjectDAO;	//temp
//	@Autowired
//	private StudentDAO studentDAO;	//temp
	@Autowired
	private ThesisDAO thesisDAO;	//temp

	@RequestMapping("/professor/dashboard")
    public String getProfessorHome(){
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    	String currentPrincipalName = authentication.getName();
        return "professor/dashboard";
    }
    
    @RequestMapping("/professor/profile")
	public String retrieveProfile(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	Professor professor = professorService.retrieveProfile(currentPrincipalName);
    	model.addAttribute("professor", professor);
    	return "professor/profile";
	}

    //for partial save see https://www.baeldung.com/spring-data-partial-update
    @PostMapping("/professor/save")
	public String saveProfile(@ModelAttribute("professor") Professor professor, Model model) {
    	professorService.saveProfile(professor);
		return "redirect:/professor/dashboard";
	}
	
    @RequestMapping("/professor/subjects")
	public String listProfessorSubjects(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
    	List<Subject> subjects = professorService.listProfessorSubjects(currentPrincipalName);
    	model.addAttribute("subjects", subjects);
		return "professor/subjects";
	}
	
    //TODO should these go in subject controller?
    @PostMapping("/professor/save-subject")
	public String saveSubject(@ModelAttribute("subject") Subject subject, Model model) {
    	subjectService.save(subject);
		return "redirect:/professor/subjects";
	}
    
    @RequestMapping("/professor/add-subject")
    public String addSubject(/*Subject subject, */Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
    	Professor professor = professorService.retrieveProfile(currentPrincipalName);
    	Subject subject = new Subject();
    	subject.setProfessor(professor);//professorService.addSubject(string, subject);
    	model.addAttribute("subject", subject);
    	return "/professor/subject";
    }
    
    @RequestMapping("/professor/delete-subject")
    public String deleteSubject(@RequestParam("subjectId") int subjectId, Model model) {
    	subjectService.deleteById(subjectId);
		return "redirect:/professor/subjects";
	}
	
    @RequestMapping("/professor/applications")
	public String listApplications(@RequestParam("subjectId") int subjectId, Model model) {
    	List<Application> applications = professorService.listApplications(subjectId);
    	model.addAttribute("applications", applications);
    	model.addAttribute("subjectId", subjectId);
		return "/professor/applications";
	}//TODO can't see apps
	
    @RequestMapping("/professor/assignSubject")
	public String assignSubject(
			@RequestParam("subjectId") int subjectId, 
			//@RequestParam("applicationId") int applicationId, 
			@RequestParam("strategyName") String strategyName, 
			Model model) {
		
    	Thesis thesis = new Thesis();    	
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
    	Professor professor = professorService.retrieveProfile(currentPrincipalName);
    	thesis.setProfessor(professor);
    	
    	Subject subject = subjectDAO.findById(subjectId);
    	thesis.setSubject(subject);
    	
    	BestApplicantStrategy strategy = BestApplicantStrategyFactory.createStrategy(strategyName);
    	Student student = strategy.findBestApplicant(subject.getApplications());//studentDAO.findByApplicationId(applicationId);
    	thesis.setStudent(student);
    	
    	thesisDAO.save(thesis);
    	
    	return "redirect:/professor/subjects";
	}
	
	@RequestMapping("/professor/theses")
	public String listProfessorTheses(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
    	List<Thesis> theses = professorService.listProfessorTheses(currentPrincipalName);
    	model.addAttribute("theses", theses);
		return "professor/theses";
	}
	
}//TODO show only available subjects