package com.aaditya2200.medicalrecordapi.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqExchangeConfig {

    @Autowired
    private RabbitMqEnvironmentConfig rabbitMqEnvironmentConfig;

    @Bean
    TopicExchange medicalRecordExchange() {
        return new TopicExchange(rabbitMqEnvironmentConfig.getMedicalRecordExchange());
    }
}
