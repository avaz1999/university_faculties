package uz.university.faculty.univerist_faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private Long id;
    private String name;
    private List<String> authors;
    private String base64;
}
