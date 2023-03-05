package com.aaditya2200.medicalrecordapi.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void publishMessage(String exchangeName, String routingKey, Object object) {
        try {
            Message message = null;
            if (object instanceof Message) {
                message = (Message) object;
            } else {
                message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(object))
                                                .setContentType(MediaType.APPLICATION_JSON_VALUE).build();
            }
            rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
        } catch (AmqpException | JsonProcessingException exception) {
        }
    }
}
