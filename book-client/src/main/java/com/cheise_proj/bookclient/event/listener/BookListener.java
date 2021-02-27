package com.cheise_proj.bookclient.event.listener;

import com.cheise_proj.bookclient.event.process.BookProcessor;
import com.cheise_proj.bookclient.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(BookProcessor.class)
@Slf4j
public class BookListener {
    @StreamListener(target = BookProcessor.INPUT)
    public void handleEvent(@Payload Book book) {
        log.info("received message {}", book);
    }
}
