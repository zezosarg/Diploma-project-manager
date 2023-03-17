package diplomaProjectManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    	return "professor/profile";
	}

    @PostMapping("/professor/profile/save")
	public String saveProfile(@ModelAttribute("professor") Professor professor, Model model) {
    	professorService.saveProfile(professor);
		return "redirect:/professor/profile";
	}
	
	String listProfessorSubjects(Model model) {
		return "";
	}
	
	String showSubject(Model model) {
		return "";
	}
	
	String addSubject(Subject subject, Model model) {
		return "";
	}
	
	String listApplications(Integer integer, Model model) {
		return "";
	}
	
	String assignSubject(Integer integer, Model model) {
		return "";
	}
	
	String listProfessorTheses(Model model) {
		return "";
	}
	
}
