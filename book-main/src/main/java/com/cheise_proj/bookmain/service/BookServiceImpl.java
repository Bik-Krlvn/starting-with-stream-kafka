package com.cheise_proj.bookmain.service;

import com.cheise_proj.bookmain.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import java.util.UUID;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    private final StreamBridge streamBridge;

    @Autowired
    public BookServiceImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public boolean createBook(Book book) {
        log.info("sending event {}", book);
        book.setId(UUID.randomUUID().toString());
        Message<Book> message = MessageBuilder
                .withPayload(book)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        log.info("message sent {}", message.toString());
        return streamBridge.send(BOOK_EVENT_PRODUCER, message);
    }
}
