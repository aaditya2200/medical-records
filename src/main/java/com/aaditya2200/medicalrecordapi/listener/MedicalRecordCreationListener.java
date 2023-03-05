package com.aaditya2200.medicalrecordapi.listener;

import com.aaditya2200.medicalrecordapi.models.MedicalRecordMessageModel;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Builder;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Component
public class MedicalRecordCreationListener {

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${medicalRecordCreationQueueName}")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void onMessage(Message message) {
        try {
            final MedicalRecordMessageModel medicalRecordMessageModel = objectMapper.readValue(message.getBody(),
                                            MedicalRecordMessageModel.class);
            final String path = medicalRecordMessageModel.getFileLocation();
            File file = new File(path);
            final String bucketName = "electronic-health-record-test-aaditya";
            AmazonS3 amazonS3Client = AmazonS3Client.builder().build();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, medicalRecordMessageModel.getHospitalName() + "/"
                                            + medicalRecordMessageModel.getPatientName()
                                            + "/" + file.getName(), file);
            amazonS3Client.putObject(putObjectRequest);
        } catch (Exception e) {

        }
    }
}
