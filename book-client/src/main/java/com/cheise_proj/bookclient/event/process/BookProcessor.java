package com.cheise_proj.bookclient.event.process;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BookProcessor {
    String INPUT = "book-event-consumer";

    @Input(INPUT)
    SubscribableChannel inboundBook();
}
