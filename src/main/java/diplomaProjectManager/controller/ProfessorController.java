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

import diplomaProjectManager.model.Application;
import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;
import diplomaProjectManager.service.ProfessorService;
import diplomaProjectManager.service.SubjectService;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/professor/dashboard")
    public String getProfessorHome(){
        return "professor/dashboard";
    }
    
    @RequestMapping("/professor/profile")
	public String retrieveProfile(Model model) {
    	Professor professor = professorService.retrieveProfile(getCurrentPrincipal());
    	model.addAttribute("professor", professor);
    	return "professor/profile";
	}

    @PostMapping("/professor/save")
	public String saveProfile(@ModelAttribute("professor") Professor professor, Model model) {
    	professorService.saveProfile(professor);
		return "redirect:/professor/dashboard";
	}
	
    @RequestMapping("/professor/subjects")
	public String listProfessorSubjects(Model model) {
    	List<Subject> subjects = professorService.listProfessorSubjects(getCurrentPrincipal());
    	model.addAttribute("subjects", subjects);
		return "professor/subjects";
	}
	
    @PostMapping("/professor/save-subject")
	public String saveSubject(@ModelAttribute("subject") Subject subject, Model model) {
    	subjectService.save(subject);
		return "redirect:/professor/subjects";
	}
    
    @RequestMapping("/professor/add-subject")
    public String addSubject(Model model) {
    	Subject subject = professorService.addSubject(getCurrentPrincipal());
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
	}
	
    @RequestMapping("/professor/assignSubject")
	public String assignSubject(@RequestParam("subjectId") int subjectId, @RequestParam("strategy") String strategy,
	@RequestParam(name = "t1", required = false) Integer t1, @RequestParam(name = "t2", required = false) Integer t2, Model model) {
    	if (t1 != null && t2 != null)
    		professorService.assignSubject(getCurrentPrincipal(), strategy, subjectId, t1, t2);
    	else
    		professorService.assignSubject(getCurrentPrincipal(), strategy, subjectId);
    	return "redirect:/professor/subjects";
	}
	
	@RequestMapping("/professor/theses")
	public String listProfessorTheses(Model model) {
    	List<Thesis> theses = professorService.listProfessorTheses(getCurrentPrincipal());
    	model.addAttribute("theses", theses);
		return "professor/theses";
	}
	
	@RequestMapping("/professor/setGrades")
	public String setGrades(@RequestParam("thesisId") int thesisId, Model model) {
		Thesis thesis = professorService.retrieveThesis(thesisId);
    	model.addAttribute("thesis", thesis);
    	return "professor/thesis";
	}
	
	@PostMapping("/professor/saveThesis")
	public String saveThesis(@ModelAttribute("thesis") Thesis thesis, Model model) {
    	thesis.calculateGrade();
		professorService.saveThesis(thesis);
		return "redirect:/professor/theses";
	}
	
	public String getCurrentPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}