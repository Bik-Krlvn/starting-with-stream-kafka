package com.cheise_proj.bookmain.controller;

import com.cheise_proj.bookmain.model.Book;
import com.cheise_proj.bookmain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public boolean createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
