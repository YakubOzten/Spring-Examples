package com.yakubozten.exception;

import com.yakubozten.dto.ResponseMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FileUploadExpectionAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseMessageDto> handleMaxSizeException(MaxUploadSizeExceededException exc){
        return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageDto("File too large!"));
    }
}
