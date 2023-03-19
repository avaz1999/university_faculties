package uz.university.faculty.univerist_faculty.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.university.faculty.univerist_faculty.dto.BookDto;
import uz.university.faculty.univerist_faculty.entity.Attachment;
import uz.university.faculty.univerist_faculty.entity.Book;
import uz.university.faculty.univerist_faculty.service.BookService;

import java.io.File;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public String getAllBooks(Model model){
         model.addAttribute("bookList",bookService.getAllBooks());
         return "view-books";
    }
    @GetMapping("/add-book")
    public String addBook(Model model){
        model.addAttribute("faculties",bookService.getFaculties());
        model.addAttribute("languages",bookService.getAllLanguageList());
        model.addAttribute("isPhoto",new Attachment());
        return "add_book";
    }
    @PostMapping
    public String addNewBook(BookDto bookDto ){
        bookService.addNewBook(bookDto);
        return "redirect:/books";
    }

    @GetMapping("/download/{id}")
   public void downloadFile(@PathVariable Long id, HttpServletResponse response){
        bookService.getBookById(id,response);
    }
}
