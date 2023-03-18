package uz.university.faculty.univerist_faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.university.faculty.univerist_faculty.service.GroupService;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @GetMapping("/{id}")
    public String getAllGroupByUniversityId(@PathVariable Long id, Model model){
        return "about";
    }
}
