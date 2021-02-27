package com.cheise_proj.bookmain.event.process;

import com.cheise_proj.bookmain.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import java.util.UUID;
import java.util.function.Supplier;

@Component
public class BookProcessor {
    @Bean
    public Supplier<Message<Book>> supplier() {
        return this::createEvent;

    }

    private Message<Book> createEvent() {
        Book book = new Book(UUID.randomUUID().toString(), "Avatar - The last air bender");
        return MessageBuilder
                .withPayload(book)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
    }

}
