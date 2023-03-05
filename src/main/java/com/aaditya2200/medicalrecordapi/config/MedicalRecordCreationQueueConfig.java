package com.aaditya2200.medicalrecordapi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicalRecordCreationQueueConfig {

    @Autowired
    private RabbitMqEnvironmentConfig rabbitMqEnvironmentConfig;

    @Autowired
    private RabbitMqExchangeConfig rabbitMqExchangeConfig;

    @Bean
    public Queue medicalRecordCreationQueue() {
        return new Queue(rabbitMqEnvironmentConfig.getMedicalRecordCreationQueue());
    }

    @Bean
    public Binding medicalRecordCreationQueueBindingWithExchange() {
        return BindingBuilder.bind(medicalRecordCreationQueue())
                                        .to(rabbitMqExchangeConfig.medicalRecordExchange())
                                        .with(rabbitMqEnvironmentConfig.getMedicalRecordCreationBindingKey());
    }

}
