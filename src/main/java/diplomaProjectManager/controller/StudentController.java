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

import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.model.Thesis;
import diplomaProjectManager.service.StudentService;
import diplomaProjectManager.service.SubjectService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private SubjectService subjectService;

    @RequestMapping("/student/dashboard")
    public String getStudentHome(Model model){
    	Student student = studentService.retrieveProfile(getCurrentPrincipal());
    	Thesis thesis = studentService.getThesis(student.getUsername());
    	if (thesis!=null)
    		model.addAttribute("successMessage", 
    				"You have been assigned subject "+thesis.getSubject().getTitle()
    				+" by "+thesis.getSubject().getProfessor().getFullname()
    				+" with the objective to "+thesis.getSubject().getObjectives()
    		);
        return "student/dashboard";
    }
    
    @RequestMapping("/student/profile")
	public String retrieveProfile(Model model) {
    	Student student = studentService.retrieveProfile(getCurrentPrincipal());
    	model.addAttribute("student", student);
    	return "student/profile";
	}
    
    @PostMapping("/student/save")
	public String saveProfile(@ModelAttribute("student") Student student, Model model) {
    	studentService.saveProfile(student);
		return "redirect:/student/dashboard";
	}
    
    @RequestMapping("/student/subjects")
	public String listStudentSubjects(Model model) {
    	List<Subject> subjects = studentService.listStudentSubjects();
    	model.addAttribute("subjects", subjects);
		return "student/subjects";
	}
    
    @RequestMapping("/student/applyToSubject")
    public String applyToSubject(@RequestParam("subjectId") int subjectId, Model model) {
		studentService.applyToSubject(getCurrentPrincipal(), subjectId);
    	return "redirect:/student/subjects";
    }
    
    @RequestMapping("/student/subjectDetails")
    public String showSubject(@RequestParam("subjectId") int subjectId, Model model) {
    	Subject subject = subjectService.findById(subjectId);
    	model.addAttribute("subject", subject);
    	model.addAttribute(subject.getProfessor());
    	return "student/subject";
    }
    
    public String getCurrentPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
