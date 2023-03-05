package com.aaditya2200.medicalrecordapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medical_records")
@Getter
@Setter
@AllArgsConstructor
public class MedicalRecordEntity {
    private String name;
    private String age;
    private String gender;
    private String anyPresentHealthProblems;
    private String hospitalName;
    private String patientFilePath;
}
