package com.aaditya2200.medicalrecordapi.repository;

import com.aaditya2200.medicalrecordapi.models.MedicalRecordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends MongoRepository<MedicalRecordEntity, Integer> {
    public Optional<MedicalRecordEntity> findByName(String name);
}
