package uz.university.faculty.univerist_faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.university.faculty.univerist_faculty.dto.FacultyDto;
import uz.university.faculty.univerist_faculty.entity.Faculty;
import uz.university.faculty.univerist_faculty.entity.Groups;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    @Query(nativeQuery = true,value = "" +
            "select * from faculties")
    List<Faculty> getAllFaculties();

    @Query(nativeQuery = true,value = "" +
            "select * from faculties f where f.id=:id")
    Faculty getFacultyById(Long id);

//    @Query(nativeQuery = true,value = "select g.id,g.name,g.group_number, g.faculty_id from groups g join faculties f on f.id = g.faculty_id where f.id=:id")
 @Query(nativeQuery = true,value = "select g.id as id, g.name as name, g.group_number as groupNumber from groups g join faculties f on g.faculty_id = f.id where f.id=:id")
    List<GroupProjection> getGroupByUniversityId(Long id);
}
