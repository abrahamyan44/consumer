package com.polixis.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polixis.task.entity.Message;
import com.polixis.task.repository.ConsumerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {


    private final ConsumerRepository consumerRepository;

    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @Transactional
    public void consumeMessage (String receivedMessage){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Message  message = objectMapper.readValue(receivedMessage, Message.class);

            this.consumerRepository.save(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
