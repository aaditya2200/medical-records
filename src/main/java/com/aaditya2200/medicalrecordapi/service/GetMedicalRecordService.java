package com.aaditya2200.medicalrecordapi.service;

import com.aaditya2200.medicalrecordapi.models.MedicalRecordEntity;
import com.aaditya2200.medicalrecordapi.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetMedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecordEntity> getAllMedicalRecords() {
        List<MedicalRecordEntity> medicalRecordEntityOptional = medicalRecordRepository.findAll();
        return medicalRecordEntityOptional;
    }

    public MedicalRecordEntity getMedicalRecordByName(String name) {
        Optional<MedicalRecordEntity> medicalRecordEntityOptional = medicalRecordRepository.findByName(name);
        return medicalRecordEntityOptional.orElse(null);
    }

}
