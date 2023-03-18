package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import uz.university.faculty.univerist_faculty.repository.GroupRepository;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
