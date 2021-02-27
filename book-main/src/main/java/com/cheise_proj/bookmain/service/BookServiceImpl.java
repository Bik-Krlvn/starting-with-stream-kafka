package com.cheise_proj.bookmain.service;

import com.cheise_proj.bookmain.event.producer.BookProcessor;
import com.cheise_proj.bookmain.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.UUID;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookProcessor bookProcessor;

    @Autowired
    public BookServiceImpl(BookProcessor bookProcessor) {
        this.bookProcessor = bookProcessor;
    }


    @Override
    public boolean createBook(Book book) {
        log.info("sending event {}", book);
        book.setId(UUID.randomUUID().toString());
        MessageChannel messageChannel = bookProcessor.outboundBook();
        Message<Book> message = MessageBuilder
                .withPayload(book)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        log.info("message sent {}", message.toString());
        return messageChannel.send(message);
    }
}
