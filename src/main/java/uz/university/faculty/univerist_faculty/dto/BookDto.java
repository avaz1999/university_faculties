package uz.university.faculty.univerist_faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import uz.university.faculty.univerist_faculty.entity.Book;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class    BookDto {
    private Long id;
    private String name;
    private String authors;

    private Long facultyId;
    private String description;
    private String base64;
    private Long languageId;
    private MultipartFile file;

    public BookDto(Long id, String name, String authors, String base64,String description) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.base64 = base64;
        this.description = description;
    }

    public BookDto(String name, String authors, MultipartFile file) {
        this.name = name;
        this.authors = authors;
        this.file = file;
    }
}
