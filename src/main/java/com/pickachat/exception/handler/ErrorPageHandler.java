package com.pickachat.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * 에러 상황 발생시 오류 페이지로 이동시키는 핸들러
 */
public class ErrorPageHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorPageHandler.class);

    public static ModelAndView handle(String viewName, String errorCode, String message, Exception ex) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("errorCode", errorCode);
        mav.addObject("message", message);
        logger.error("에러 발생 - 코드: {}, 메시지: {}", errorCode, message);
        return mav;
    }
}
