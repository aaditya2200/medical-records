package com.aaditya2200.medicalrecordapi.controller;

import com.aaditya2200.medicalrecordapi.models.request.RecordCreationRequestModel;
import com.aaditya2200.medicalrecordapi.service.MedicalRecordCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import static com.aaditya2200.medicalrecordapi.constants.MedicalRecordConstants.CREATE_RECORD;

@RestController
@Validated
public class CreateMedicalRecordController {

    @Autowired
    private MedicalRecordCreationService medicalRecordCreationService;

    @PostMapping(CREATE_RECORD)
    public ResponseEntity<HttpStatus> createMedicalRecordController(@Valid @RequestBody RecordCreationRequestModel recordCreationRequestModel) {
        medicalRecordCreationService.createMedicalRecord(recordCreationRequestModel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
