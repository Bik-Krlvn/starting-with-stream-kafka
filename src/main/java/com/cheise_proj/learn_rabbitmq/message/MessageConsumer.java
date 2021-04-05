package com.cheise_proj.learn_rabbitmq.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

@Component
@Slf4j
public class MessageConsumer {
    @Bean
    public Consumer<Map<String, String>> bookCreatedConsumer() {
        return stringStringMap -> log.info("[x] received {}", stringStringMap.toString());
    }
}
