package com.cheise_proj.learn_rabbitmq.message;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProducerImpl implements Producer {

    private final StreamBridge streamBridge;

    public ProducerImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @Override
    public boolean sendToQueue(String topic, Message<Map<String, String>> message) {
        return streamBridge.send(topic, message);
    }
}
