package uz.university.faculty.univerist_faculty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "titles")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titleName;

    @OneToMany(mappedBy = "title")
    private List<Attachment> attachments;


    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
}
