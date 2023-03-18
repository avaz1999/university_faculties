package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import uz.university.faculty.univerist_faculty.dto.FacultyDto;
import uz.university.faculty.univerist_faculty.dto.GroupDto;
import uz.university.faculty.univerist_faculty.entity.Faculty;
import uz.university.faculty.univerist_faculty.entity.Groups;
import uz.university.faculty.univerist_faculty.repository.FacultyRepository;
import uz.university.faculty.univerist_faculty.repository.GroupProjection;

import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<FacultyDto> getAllUniversityFaculties() {
        List<Faculty> faculties = facultyRepository.getAllFaculties();
        return facultyDtoFactory(faculties);
    }

    private List<FacultyDto> facultyDtoFactory(List<Faculty> faculties) {
        List<FacultyDto> facultyDtoList = new ArrayList<>();
        for (Faculty faculty : faculties) {
            FacultyDto facultyDto = new FacultyDto(
                    faculty.getId(),
                    faculty.getName(),
                    faculty.getDescription(),
                    faculty.getBase64Encode());
        facultyDtoList.add(facultyDto);
        }
        return facultyDtoList;
    }

    public FacultyDto getFacultyById(Long id) {
        Faculty faculty = facultyRepository.getFacultyById(id);
        return new FacultyDto(faculty.getId(),faculty.getName(), faculty.getDescription(),faculty.getBase64Encode());
    }

    public List<GroupDto> getAllGroupByUniversityId(Long id) {
        List<GroupProjection> groupByUniversityId = facultyRepository.getGroupByUniversityId(id);
        return convertDto(groupByUniversityId);
    }

    private List<GroupDto> convertDto(List<GroupProjection> groupByUniversityId) {
        List<GroupDto> groupDtoList = new ArrayList<>();
        for (GroupProjection groups : groupByUniversityId) {
            GroupDto groupDto = new GroupDto(
                    groups.getId(),
                    groups.getName(),
                    groups.getGroupNumber());
            groupDtoList.add(groupDto);
        }

        return groupDtoList;
    }
}
