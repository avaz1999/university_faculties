package uz.university.faculty.univerist_faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FacultyDto {
    private Long id;
    private String facultyName;
    private long universityId;
    private String description;
    private MultipartFile file;
    private String base64;

    public FacultyDto(Long id, String name, String description, String base64Encode) {
        this.id = id;
        this.facultyName = name;
        this.description = description;
        this.base64 = base64Encode;
    }
}
