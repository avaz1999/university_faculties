package uz.university.faculty.univerist_faculty.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private String contentType;
    @Column(nullable = false)
    private Boolean isPhoto = false;

    @Column(nullable = false)
    private byte[] bytes;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

    public Attachment(String name, String contentType, byte[] bytes,Boolean isPhoto) {
        this.fileName = name;
        this.contentType = contentType;
        this.bytes = bytes;
        this.isPhoto = isPhoto;
    }

    public Attachment(String name, String contentType, byte[] bytes) {
        this.fileName = name;
        this.contentType = contentType;
        this.bytes = bytes;
    }
}
