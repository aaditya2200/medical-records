package com.aaditya2200.medicalrecordapi.service;

import com.aaditya2200.medicalrecordapi.config.RabbitMqEnvironmentConfig;
import com.aaditya2200.medicalrecordapi.config.RabbitMqExchangeConfig;
import com.aaditya2200.medicalrecordapi.exceptions.MedicalRecordException;
import com.aaditya2200.medicalrecordapi.models.MedicalRecordMessageModel;
import com.aaditya2200.medicalrecordapi.models.request.RecordCreationRequestModel;
import com.aaditya2200.medicalrecordapi.publisher.MessagePublisher;
import com.aaditya2200.medicalrecordapi.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordCreationService {

    @Autowired
    private MessagePublisher messagePublisher;

    @Autowired
    private RabbitMqEnvironmentConfig rabbitMqEnvironmentConfig;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public void createMedicalRecord(RecordCreationRequestModel recordCreationRequestModel) {
        recordCreationRequestModel.getMedicalRecordEntityList().forEach(medicalRecordEntity -> {
            medicalRecordRepository.save(medicalRecordEntity);
            MedicalRecordMessageModel medicalRecordMessageModel = new MedicalRecordMessageModel();
            medicalRecordMessageModel.setFileLocation(medicalRecordEntity.getPatientFilePath());
            medicalRecordMessageModel.setHospitalName(medicalRecordEntity.getHospitalName());
            medicalRecordMessageModel.setPatientName(medicalRecordEntity.getName());
            messagePublisher.publishMessage(rabbitMqEnvironmentConfig.getMedicalRecordExchange(),
                                            rabbitMqEnvironmentConfig.getMedicalRecordCreationBindingKey(),
                                            medicalRecordMessageModel);
        });
    }

}
