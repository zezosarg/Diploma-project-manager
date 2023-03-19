package diplomaProjectManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.service.ProfessorService;
import diplomaProjectManager.service.SubjectService;
import diplomaProjectManager.service.UserService;

@Controller
public class ProfessorController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private SubjectService subjectService;

    @RequestMapping("/professor/dashboard")
    public String getProfessorHome(){
//    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    	String currentPrincipalName = authentication.getName();
//    	System.err.println(currentPrincipalName);

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
    @PostMapping("/professor/profile/save")
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
	
	public String showSubject(Model model) {
		return "";
	}
	
	public String addSubject(Subject subject, Model model) {
		return "";
	}
	
	public String listApplications(Integer integer, Model model) {
		return "";
	}
	
	public String assignSubject(Integer integer, Model model) {
		return "";
	}
	
	public String listProfessorTheses(Model model) {
		return "";
	}
	
}
