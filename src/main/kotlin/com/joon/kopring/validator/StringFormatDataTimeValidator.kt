package com.joon.kopring.validator

import com.joon.kopring.annotation.StringFormatDataTime
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class StringFormatDataTimeValidator : ConstraintValidator<StringFormatDataTime, String> {

    private var pattern: String? = null

    override fun initialize(constraintAnnotation: StringFormatDataTime) {
        this.pattern = constraintAnnotation.pattern
    }

    // 정상이면 true, 비정상이면 false
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return try {
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern("pattern"))
            true
        } catch (e: Exception) {
            false
        }
    }

}