package com.suv.employeeservice.configuration;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;
import java.time.LocalDateTime;

/**
 * Created by esuv on 2019-11-29
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity handleConnectionException(RuntimeException ex) {
        logger.error("connection exception", ex);
        val response = EmployeeError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .error(ex.getMessage())
                .message("error")
                .build();
        return new ResponseEntity<>(response, response.status);
    }

    @Builder
    @Data
    private static class EmployeeError {

        private LocalDateTime timestamp;
        private HttpStatus status;
        private String error;
        private String message;
    }
}
