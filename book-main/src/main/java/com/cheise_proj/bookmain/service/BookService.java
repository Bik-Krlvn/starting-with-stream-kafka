package com.cheise_proj.bookmain.service;

import com.cheise_proj.bookmain.model.Book;

public interface BookService {
    String BOOK_EVENT_PRODUCER = "book-event-producer";
    boolean createBook(Book book);
}
