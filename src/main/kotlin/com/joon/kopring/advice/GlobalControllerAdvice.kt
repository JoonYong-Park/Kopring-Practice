package com.joon.kopring.advice

import com.joon.kopring.controller.exception.ExceptionApiController
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

//@RestControllerAdvice(basePackageClasses = [ExceptionApiController::class]) // 해당 패키지에만 적용
class GlobalControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class]) // 실행중 발생하는 모든 예외를 처리
    fun exception(e: RuntimeException): String {
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])  // 인덱스 범위를 벗어난 예외를 처리
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error") // 500 에러
    }

}