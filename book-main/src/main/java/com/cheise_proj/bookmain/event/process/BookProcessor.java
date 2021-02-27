package com.cheise_proj.bookmain.event.process;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookProcessor {
    String OUTPUT = "book-event-producer";

    @Output(OUTPUT)
    MessageChannel outboundBook();
}
