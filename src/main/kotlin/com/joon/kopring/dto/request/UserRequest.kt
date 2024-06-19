package com.joon.kopring.dto.request

import com.joon.kopring.annotation.StringFormatDataTime
import jakarta.validation.constraints.*
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest(
    @field:NotEmpty
    @field:Size(min = 2, max = 8, message = "name의 길이는 2~8")
    var name: String? = null,

    @field:PositiveOrZero // 0 이상 검증
    var age: Int? = null,

    @field:Email // 이메일 검증
    var email: String? = null,

    @field:NotBlank // 공백 검증
    var address: String? = null,

//    @JsonProperty("phone_number") // 개별 지정
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$") // 정규식 검증
    var phoneNumber: String? = null, // phone_number

    @field:StringFormatDataTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
    var createdAt: String? = null   // 2024-10-10 13:00:00
){
    // StringFormatDataTime으로 대체
//    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 여야 합니다.")
//    private fun isValidCreatedAt(): Boolean {
//        return try {
//            LocalDateTime.parse(createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
}