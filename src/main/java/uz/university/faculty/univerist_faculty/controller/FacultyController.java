package uz.university.faculty.univerist_faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.university.faculty.univerist_faculty.service.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping
    public String getAllFaculty(Model model){
        model.addAttribute("faculties",facultyService.getAllUniversityFaculties());
        return "index";
    }
    @GetMapping("/get-by-id/{id}")
    public String getFacultyById(@PathVariable Long id, Model model){
        model.addAttribute("get_faculty",facultyService.getFacultyById(id));
        return "about";
    }
}
