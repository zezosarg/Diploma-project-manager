package diplomaProjectManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/student/dashboard")
    public String getStudentHome(){
        return "student/dashboard";
    }
}
