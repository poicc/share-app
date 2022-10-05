package com.crq.content.handler;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: crq
 * @description:
 * @date: 2022/10/4 16:09
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionErrorHandler {
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity error(SecurityException e) {
        log.warn("发生SecurityException异常", e);
        return new ResponseEntity<>(
                ErrorBody.builder().body(e.getMessage()).status(HttpStatus.UNAUTHORIZED.value()).build(),
                HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handlerNull(NullPointerException e) {
        log.warn("发生NullPointerException异常", e);
        return new ResponseEntity<>(
                ErrorBody.builder().body(e.getMessage()).status(HttpStatus.OK.value()).build(),
                HttpStatus.NOT_FOUND
        );
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class ErrorBody {
    private String body;
    private int status;
}
