package com.aaditya2200.medicalrecordapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MedicalRecordMessageModel {

    private String patientName;
    private String hospitalName;
    private String fileLocation;
}
