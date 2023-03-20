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
import org.springframework.web.bind.annotation.RequestParam;
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
//Can i save professor in model???
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
	
    //should these go in subject controller?
    @PostMapping("/subject/save")
	public String saveSubject(@ModelAttribute("subject") Subject subject, Model model) {
    	subjectService.save(subject);
		return "redirect:/professor/subjects";
	}
    
    //need to pass prof id to subject
    @RequestMapping("/professor/add-subject")
    public String addSubject(/*Subject subject, */Model model) {
    	Subject subject = new Subject();
    	model.addAttribute("subject", subject);
    	return "/professor/add-subject";
    }
    
    @RequestMapping("/professor/delete-subject")
    public String deleteSubject(@RequestParam("subjectId") int subjectId, Model model) {
    	subjectService.deleteById(subjectId);
		return "redirect:/professor/subjects";
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
