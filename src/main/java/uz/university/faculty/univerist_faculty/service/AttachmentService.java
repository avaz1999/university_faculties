package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.university.faculty.univerist_faculty.entity.Attachment;
import uz.university.faculty.univerist_faculty.repository.AttachmentRepository;

import java.io.IOException;

@Service
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public String saveAttachment(MultipartFile file) {
        try {
            attachmentRepository.save(new Attachment(file.getName(), file.getContentType(), file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Successfully saved";
    }
}
