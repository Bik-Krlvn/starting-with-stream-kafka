package com.cheise_proj.bookclient.event.listener;

import com.cheise_proj.bookclient.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class BookListener {
    @Bean
    public Consumer<Book> handleBookEvent() {
        return book -> log.info("received message {}", book);
    }

}

