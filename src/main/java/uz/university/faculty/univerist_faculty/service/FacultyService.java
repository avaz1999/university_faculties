package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import uz.university.faculty.univerist_faculty.dto.FacultyDto;
import uz.university.faculty.univerist_faculty.entity.Faculty;
import uz.university.faculty.univerist_faculty.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;

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
        FacultyDto facultyDto = new FacultyDto();
        for (Faculty faculty : faculties) {
            facultyDto.setId(faculty.getId());
            facultyDto.setFacultyName(faculty.getName());
        }
        facultyDtoList.add(facultyDto);
        return facultyDtoList;
    }
}
