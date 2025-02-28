package com.pickachat.exception;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import com.pickachat.exception.errors.Exception404;
import com.pickachat.exception.errors.Exception500;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

/**
 *  직접 던진 에러가 아닌 경우 이 곳에서 처리
 */
@Controller
@RequiredArgsConstructor
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public void handleError(HttpServletRequest request, Model model) {
        // 에러 정보 가져 오기
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(new ServletWebRequest(request), ErrorAttributeOptions.defaults());

        // 상태 코드와 메시지 확인
        int statusCode = (int) errorDetails.getOrDefault("status", 500);
        String message = (String) errorDetails.getOrDefault("message", "알 수 없는 오류가 발생 했습니다.");

        // 상태 코드에 따라 예외 던지기
        switch (statusCode) {
            case 404:
                throw new Exception404("페이지를 찾을 수 없습니다.");
            case 500:
                throw new Exception500(message);
            default:
                throw new RuntimeException("알 수 없는 상태 코드: " + statusCode);
        }
    }
}
