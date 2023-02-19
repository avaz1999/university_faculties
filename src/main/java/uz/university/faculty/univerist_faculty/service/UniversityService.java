package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import uz.university.faculty.univerist_faculty.dto.UniversityDto;
import uz.university.faculty.univerist_faculty.entity.University;
import uz.university.faculty.univerist_faculty.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService {
    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<UniversityDto> getAllUniversities() {
        List<University> getAllUniversity = universityRepository.findAll();
        return universityDtoFactory(getAllUniversity);
    }

    private List<UniversityDto> universityDtoFactory(List<University> getAllUniversity) {
        List<UniversityDto> universityDtoList = new ArrayList<>();
            UniversityDto universityDto = new UniversityDto();
        for (University university : getAllUniversity) {
            universityDto.setName(university.getName());
        }
        universityDtoList.add(universityDto);
        return universityDtoList;
    }
}
