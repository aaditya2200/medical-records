package com.aaditya2200.medicalrecordapi.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class RabbitMqEnvironmentConfig {

    @Value("${medicalRecordCreationQueueName}")
    private String medicalRecordCreationQueue;

    @Value("${medicalRecordCreationBindingKeyName}")
    private String medicalRecordCreationBindingKey;

    @Value("${medicalRecordExchangeName}")
    private String medicalRecordExchange;
}
