package uz.university.faculty.univerist_faculty.service;

import org.springframework.stereotype.Service;
import uz.university.faculty.univerist_faculty.dto.BookDto;
import uz.university.faculty.univerist_faculty.entity.Attachment;
import uz.university.faculty.univerist_faculty.entity.Book;
import uz.university.faculty.univerist_faculty.entity.Faculty;
import uz.university.faculty.univerist_faculty.entity.Language;
import uz.university.faculty.univerist_faculty.repository.AttachmentRepository;
import uz.university.faculty.univerist_faculty.repository.BookRepository;
import uz.university.faculty.univerist_faculty.repository.FacultyRepository;
import uz.university.faculty.univerist_faculty.repository.LanguageRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AttachmentRepository attachmentRepository;
    private final LanguageRepository languageRepository;
    private final FacultyRepository facultyRepository;

    public BookService(BookRepository bookRepository, AttachmentRepository attachmentRepository, LanguageRepository languageRepository, FacultyRepository facultyRepository) {
        this.bookRepository = bookRepository;
        this.attachmentRepository = attachmentRepository;
        this.languageRepository = languageRepository;
        this.facultyRepository = facultyRepository;
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
                    allBook.getBse64Encode(),
                    allBook.getDescription()
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
            Optional<Faculty> facultyFirst = facultyRepository
                    .findById(bookDto
                            .getFacultyId())
                    .stream()
                    .filter(faculty -> faculty.getId() == bookDto
                            .getFacultyId())
                    .findFirst();
            Optional<Language> first = languageRepository
                    .findById(bookDto.getLanguageId())
                    .stream()
                    .filter(language -> language
                            .getId()== bookDto
                            .getLanguageId())
                    .findFirst();
            Language language = first.get();
            Faculty faculty = facultyFirst.get();
            bookRepository.save(new Book(
                    bookDto.getName(),
                    bookDto.getAuthors(),
                    bookDto.getDescription(),
                    faculty,
                    language,
                    attachment
            ));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    public List<Language> getAllLanguageList() {
        return languageRepository.findAll();
    }
}
