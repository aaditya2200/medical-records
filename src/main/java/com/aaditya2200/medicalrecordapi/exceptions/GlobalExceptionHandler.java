package com.aaditya2200.medicalrecordapi.exceptions;

import com.aaditya2200.medicalrecordapi.models.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MedicalRecordException.class)
    public ResponseEntity<ErrorResponse> handleMedicalRecordException(MedicalRecordException medicalRecordException) {
        final ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(medicalRecordException.getErrorCode());
        errorResponse.setErrorMessage(medicalRecordException.getErrorMessage());
        return new ResponseEntity<>(errorResponse, medicalRecordException.getHttpStatus());
    }
}
