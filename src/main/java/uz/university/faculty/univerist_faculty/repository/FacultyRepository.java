package uz.university.faculty.univerist_faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.university.faculty.univerist_faculty.entity.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    @Query(nativeQuery = true,value = "" +
            "select * from faculties")
    List<Faculty> getAllFaculties();
}
