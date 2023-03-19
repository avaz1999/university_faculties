package uz.university.faculty.univerist_faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.university.faculty.univerist_faculty.entity.Attachment;
import uz.university.faculty.univerist_faculty.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

}
