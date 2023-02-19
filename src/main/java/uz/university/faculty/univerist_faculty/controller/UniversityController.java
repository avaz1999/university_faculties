package uz.university.faculty.univerist_faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.university.faculty.univerist_faculty.dto.UniversityDto;
import uz.university.faculty.univerist_faculty.service.UniversityService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class UniversityController {
    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }
    @GetMapping
    public String getAllUniversity(Model model){
        model.addAttribute("universityList",universityService.getAllUniversities());
        return "university";
    }
}
