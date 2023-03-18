package uz.university.faculty.univerist_faculty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupDto {
    private Long id;
    private String name;
    private Long groupNumber;
    private Long universityId;


    public GroupDto(Long id, String name, Long groupNumber) {
        this.id = id;
        this.name = name;
        this.groupNumber = groupNumber;
    }
}
