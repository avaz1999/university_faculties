package uz.university.faculty.univerist_faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.university.faculty.univerist_faculty.dto.BookDto;
import uz.university.faculty.univerist_faculty.service.BookService;

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
        return "add_book";
    }
    @PostMapping
    public String addNewBook(BookDto bookDto ){
        bookService.addNewBook(bookDto);
        return "redirect:/books";
    }
}
