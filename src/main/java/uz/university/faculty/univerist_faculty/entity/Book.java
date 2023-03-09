package uz.university.faculty.univerist_faculty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private List<String> authors;
    @OneToOne(cascade = CascadeType.ALL)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Attachment attachment;

    public Book(String name, List<String> authors, Attachment attachment) {
        this.name = name;
        this.authors = authors;
        this.attachment = attachment;
    }

    public String getBse64Encode(){
        if(this.attachment != null){
            byte[] bytes = Base64.getEncoder().encode(attachment.getBytes());
            try {
                return new String(bytes,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
