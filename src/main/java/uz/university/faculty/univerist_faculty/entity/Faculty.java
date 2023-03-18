package uz.university.faculty.univerist_faculty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "university_id", nullable = false)
    private University university;

    @OneToOne
    @Cascade(CascadeType.DELETE)
    @JoinColumn(name = "attachment_id", referencedColumnName = "id")
    private Attachment attachment;

    @OneToMany(mappedBy = "faculty")
    private List<Groups> groups;

    @OneToMany(mappedBy = "faculty")
    private List<Book> facultyBooks;

    public  String getBase64Encode() {
        try {
            if (this.attachment != null) {
                byte[] encode = Base64.getEncoder().encode(this.attachment.getBytes());
                return new String(encode, "UTF-8");
            }
        }catch(UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
