package com.cheise_proj.learn_rabbitmq.message;

import org.springframework.messaging.Message;

import java.util.Map;

public interface Producer {
    boolean sendToQueue(String topic, Message<Map<String, String>> message);
}
