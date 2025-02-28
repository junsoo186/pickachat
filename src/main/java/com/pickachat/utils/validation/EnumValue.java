package com.hnm.erp.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Enum 유효성 검사를 위한 커스텀 어노테이션
 */
@Constraint(validatedBy = EnumValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValue {
    // 검사할 Enum 클래스를 파라미터로 받는다.
    Class<? extends Enum<?>> enumClass();

    String message() default "Invalid value for enum.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
