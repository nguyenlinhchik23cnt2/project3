package com.example.lesson08.controller;

import Entity.author;
import Entity.book;
import service.Authorsevice;
import service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private Authorsevice authorService;

    // ==================== AUTHOR ====================
    @GetMapping("/author")
    public String listAuthor(Model model) {
        model.addAttribute("ListAuthor", authorService.GetAll());
        return "author-list";
    }

    @GetMapping("/author/create")
    public String createAuthor(Model model) {
        model.addAttribute("author", new author());
        return "author-create";
    }

    @PostMapping("/author/save")
    public String saveAuthor(@ModelAttribute author author,
                             @RequestParam("ImageFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path uploadPath = Paths.get("src/main/resources/static/images/");
                if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
                try (InputStream inputStream = file.getInputStream()) {
                    Path filePath = uploadPath.resolve(fileName);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                }
                author.setImgUrl("/images/" + fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        authorService.Save(author);
        return "redirect:/author";
    }

    @GetMapping("/author/edit/{id}")
    public String editAuthor(@PathVariable Long id, Model model) {
        author author = authorService.GetById(id);
        model.addAttribute("author", author);
        return "author-create";
    }

    // ==================== BOOK ====================
    @GetMapping("/book")
    public String listBook(Model model) {
        model.addAttribute("ListBook", bookService.GetAll());
        return "book-list";
    }

    @GetMapping("/book/create")
    public String createBook(Model model) {
        model.addAttribute("book", new book());
        model.addAttribute("ListAuthor", authorService.GetAll());
        return "book-create";
    }

    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute book book,
                           @RequestParam("authorIds") List<Long> authorIds,
                           @RequestParam("ImageFile") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path uploadPath = Paths.get("src/main/resources/static/images/");
                if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
                try (InputStream inputStream = file.getInputStream()) {
                    Path filePath = uploadPath.resolve(fileName);
                    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                }
                book.setImgUrl("/images/" + fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (authorIds != null) {
            List<author> selectedAuthors = authorService.FindAllByIds(authorIds);
            book.setAuthors(selectedAuthors);
        }

        bookService.Save(book);
        return "redirect:/book";
    }

    @GetMapping("/book/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        book book = bookService.GetById(id);
        model.addAttribute("book", book);
        model.addAttribute("ListAuthor", authorService.GetAll());
        return "book-create";
    }
}
