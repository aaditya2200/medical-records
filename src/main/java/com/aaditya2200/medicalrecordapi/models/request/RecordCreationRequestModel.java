package com.aaditya2200.medicalrecordapi.models.request;

import lombok.Getter;
import lombok.Setter;

import com.aaditya2200.medicalrecordapi.models.MedicalRecordEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import java.util.List;

@Getter
@Setter
@Component
@JsonIgnoreProperties
public class RecordCreationRequestModel {

    @JsonProperty("medicalRecords")
    List<MedicalRecordEntity> medicalRecordEntityList;

}
