package uz.university.faculty.univerist_faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.university.faculty.univerist_faculty.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
