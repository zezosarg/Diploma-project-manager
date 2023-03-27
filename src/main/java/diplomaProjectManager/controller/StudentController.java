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

import diplomaProjectManager.dao.ApplicationDAO;
import diplomaProjectManager.dao.SubjectDAO;
import diplomaProjectManager.model.Application;
import diplomaProjectManager.model.Professor;
import diplomaProjectManager.model.Student;
import diplomaProjectManager.model.Subject;
import diplomaProjectManager.service.StudentService;


@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ApplicationDAO applicationDAO; //temporary
	@Autowired
	private SubjectDAO subjectDAO;	//temporary

    @RequestMapping("/student/dashboard")
    public String getStudentHome(){
        return "student/dashboard";
    }
    
    @RequestMapping("/student/profile")
	public String retrieveProfile(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String currentPrincipalName = authentication.getName();
    	Student student = studentService.retrieveProfile(currentPrincipalName);
    	model.addAttribute("student", student);
    	return "student/profile";
	}
    
    @PostMapping("/student/save")
	public String saveProfile(@ModelAttribute("student") Student student, Model model) {
    	studentService.saveProfile(student);
		return "redirect:/student/dashboard";
	}// TODO show success message
    
    @RequestMapping("/student/subjects")
	public String listStudentSubjects(Model model) {
    	List<Subject> subjects = studentService.listStudentSubjects();
    	model.addAttribute("subjects", subjects);
		return "student/subjects";
	}
    
    @RequestMapping("/student/applyToSubject")
    public String applyToSubject(@RequestParam("subjectId") int subjectId, Model model) {
    	
    	Application application = new Application();

    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
    	Student student = studentService.retrieveProfile(currentPrincipalName);
    	student.getApplications().add(application);
    	
    	Subject subject = subjectDAO.findById(subjectId);
    	subject.getApplications().add(application);
    	
    	applicationDAO.save(application);
    	
    	return "redirect:/student/subjects";
    }	//TODO prevent multiple applications, move logic to service
    
    //public String showSubjectDetails() //TODO
}
