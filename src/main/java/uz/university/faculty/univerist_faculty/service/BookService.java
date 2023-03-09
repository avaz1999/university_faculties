package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import uz.university.faculty.univerist_faculty.dto.BookDto;
import uz.university.faculty.univerist_faculty.entity.Attachment;
import uz.university.faculty.univerist_faculty.entity.Book;
import uz.university.faculty.univerist_faculty.repository.AttachmentRepository;
import uz.university.faculty.univerist_faculty.repository.BookRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AttachmentRepository attachmentRepository;

    public BookService(BookRepository bookRepository, AttachmentRepository attachmentRepository) {
        this.bookRepository = bookRepository;
        this.attachmentRepository = attachmentRepository;
    }

    public List<BookDto> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return convertDto(allBooks);
    }

    private List<BookDto> convertDto(List<Book> allBooks) {
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book allBook : allBooks) {
            BookDto bookDto = new BookDto(
                    allBook.getId(),
                    allBook.getName(),
                    allBook.getAuthors(),
                    allBook.getBse64Encode()
                    );
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    public void addNewBook(BookDto bookDto) {
        try {
            Attachment attachment = attachmentRepository.save(new Attachment(bookDto.getFile().getName(),
                    bookDto.getFile().getContentType(),
                    bookDto.getFile().getBytes()));
            bookRepository.save(new Book(bookDto.getName(),
                    bookDto.getAuthors(),
                    attachment
            ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
