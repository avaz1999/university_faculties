package uz.university.faculty.univerist_faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private Long id;
    private String name;
    private List<String> authors;
    private String base64;
    private MultipartFile file;

    public BookDto(Long id, String name, List<String> authors, String base64) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.base64 = base64;
    }

    public BookDto(String name, List<String> authors, MultipartFile file) {
        this.name = name;
        this.authors = authors;
        this.file = file;
    }
}
