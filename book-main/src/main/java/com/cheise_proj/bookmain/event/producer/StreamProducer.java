package com.cheise_proj.bookmain.event.producer;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(BookProcessor.class)
public class StreamProducer {
    private BookProcessor bookProcessor;

    public StreamProducer(BookProcessor bookProcessor) {
        super();
        this.bookProcessor = bookProcessor;
    }

    public BookProcessor getBookProcessor() {
        return bookProcessor;
    }

    public void setBookProcessor(BookProcessor bookProcessor) {
        this.bookProcessor = bookProcessor;
    }
}
