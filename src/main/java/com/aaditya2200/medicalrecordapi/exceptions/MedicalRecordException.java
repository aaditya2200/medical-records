package com.aaditya2200.medicalrecordapi.exceptions;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MedicalRecordException extends RuntimeException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private final String errorMessage;

    private final String errorCode;

    private HttpStatus httpStatus;

    public MedicalRecordException(final String errorMessage, final String errorCode, final HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
