package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import uz.university.faculty.univerist_faculty.dto.BookDto;
import uz.university.faculty.univerist_faculty.entity.Attachment;
import uz.university.faculty.univerist_faculty.entity.Book;
import uz.university.faculty.univerist_faculty.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
                    )
        }
        return null;
    }
}
