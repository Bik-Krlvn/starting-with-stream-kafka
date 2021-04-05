package com.cheise_proj.learn_rabbitmq.controller;

import com.cheise_proj.learn_rabbitmq.common.Constants;
import com.cheise_proj.learn_rabbitmq.message.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class Book {
    private final Producer producer;

    public Book(Producer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<?> addBook() {
        Map<String, String> body = new HashMap<>();
        body.put("data", "new book added");
        Message<Map<String, String>> message = MessageBuilder.withPayload(body)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        boolean isPublished = producer.sendToQueue(Constants.BINDER_BOOK_CREATED_EVENT, message);
        if (!isPublished) return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
}
