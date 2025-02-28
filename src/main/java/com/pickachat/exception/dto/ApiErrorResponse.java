package com.pickachat.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Api 에러 응답용 DTO 클래스
 */
@AllArgsConstructor
@Getter
public class ApiErrorResponse {

    private int status;
    private String message;

}
