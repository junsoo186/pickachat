package com.pickachat.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pickachat.exception.dto.ApiErrorResponse;

/**
 *  api 요청에 대한 에러 상황 발생시 데이터를 반환하는 핸들러
 */
public class ErrorApiHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorApiHandler.class);

    public static ResponseEntity<ApiErrorResponse> handle(HttpStatus status, String message, Exception ex) {
        ApiErrorResponse response = new ApiErrorResponse(status.value(), message);
        logger.error("{} 에러 발생: {}", status, message);
        return ResponseEntity.status(status).body(response);
    }
}
