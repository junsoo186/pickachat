package com.pickachat.exception;

import com.pickachat.exception.dto.ApiErrorResponse;
import com.pickachat.exception.errors.*;
import com.pickachat.exception.handler.ErrorApiHandler;
import com.pickachat.exception.handler.ErrorPageHandler;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 전체 에러 상황을 받아서 상황에 따른 처리
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 페이지 요청 처리
    @ExceptionHandler(PageException.class)
    public ModelAndView handlePageException(RuntimeException ex) {
        String errorCode = ex.getClass().getSimpleName().replace("Exception", "");
        String message = ex.getMessage();
        return ErrorPageHandler.handle("err/error", errorCode, message, ex);
    }

    // API 요청 처리
    @ExceptionHandler(RestException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(RuntimeException ex) {
        HttpStatus status = HttpStatus.valueOf(Integer.parseInt(ex.getClass().getSimpleName().replaceAll("\\D", "")));
        return ErrorApiHandler.handle(status, ex.getMessage(), ex);
    }

    // 유효성 검사 오류 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errorMap = new HashMap<>();
        Map<String, Object> error = new HashMap<>();

        // 유효성 검사 오류 메시지 가져오기
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            error.put(err.getField(), err.getDefaultMessage());
        });

        // 유효성 검사 오류에 대해 errorType을 추가하여 구분
        errorMap.put("errorType", "VALIDATION_ERROR");
        errorMap.put("error", error);

        // 400 상태 코드와 함께 에러 메시지 반환
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

}
