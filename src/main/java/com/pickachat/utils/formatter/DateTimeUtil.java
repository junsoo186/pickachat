package com.pickachat.utils.formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.pickachat.utils.define.patterns.DateTimePatterns;

public class DateTimeUtil {

    /**
     * 기본 포맷 (yyyy-MM-dd HH:mm)으로 변환
     */
    public static String formatDefault(LocalDateTime dateTime) {
        return format(dateTime, DateTimePatterns.DEFAULT_DATETIME);
    }

    /**
     * 날짜만 포함된 포맷 (yyyy-MM-dd)으로 변환
     */
    public static String formatDateOnly(LocalDateTime dateTime) {
        return format(dateTime, DateTimePatterns.DATE_ONLY);
    }

    /**
     * 날짜만 포함된 포맷 (yyyy-MM-dd)으로 변환
     */
    public static String formatDateOnly(LocalDate date) {
        return format(date.atStartOfDay(), DateTimePatterns.DATE_ONLY);
    }

    /**
     * 시간만 포함된 포맷 (HH:mm:ss)으로 변환
     */
    public static String formatTimeOnly(LocalDateTime dateTime) {
        return format(dateTime, DateTimePatterns.TIME_ONLY);
    }

    /**
     * 전체 날짜와 시간 포맷 (yyyy-MM-dd HH:mm:ss)으로 변환
     */
    public static String formatFullDateTime(LocalDateTime dateTime) {
        return format(dateTime, DateTimePatterns.FULL_DATETIME);
    }

    /**
     * 사용자 정의 패턴으로 변환
     */
    public static String formatCustom(LocalDateTime dateTime, String pattern) {
        return format(dateTime, pattern);
    }

    /**
     * 공통 변환 로직
     */
    private static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null)
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

}
