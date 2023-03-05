package com.aaditya2200.medicalrecordapi.controller;

import com.aaditya2200.medicalrecordapi.models.MedicalRecordEntity;
import com.aaditya2200.medicalrecordapi.service.GetMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static com.aaditya2200.medicalrecordapi.constants.MedicalRecordConstants.GET_MEDICAL_RECORDS_BASE_PATH;
import static com.aaditya2200.medicalrecordapi.constants.MedicalRecordConstants.GET_RECORD_BY_NAME;

@RestController
public class GetMedicalRecordsController {

    @Autowired
    private GetMedicalRecordService getMedicalRecordService;


    @GetMapping(GET_MEDICAL_RECORDS_BASE_PATH)
    public ResponseEntity<List<MedicalRecordEntity>> getMedicalRecords() {
        List<MedicalRecordEntity> mre = getMedicalRecordService.getAllMedicalRecords();
        return new ResponseEntity<>(mre, HttpStatus.OK);
    }

    @GetMapping(GET_RECORD_BY_NAME + "/{name}")
    public ResponseEntity<MedicalRecordEntity> getMedicalRecordByName(@PathVariable String name) {
        MedicalRecordEntity medicalRecordEntity = getMedicalRecordService.getMedicalRecordByName(name);
        return new ResponseEntity<>(medicalRecordEntity, HttpStatus.OK);
    }

}
