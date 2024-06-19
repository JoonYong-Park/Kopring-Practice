package com.joon.kopring.controller.delete

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    // 1. path variable
    @DeleteMapping("/delete-mapping/{name}/{age}")
    fun deleteMappingPath(
        @Size(min = 2, max = 5, message = "age 값의 길이는 2~5")
        @NotNull(message = "name 값이 누락되었습니다.")
        @PathVariable(value = "name") _name: String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @PathVariable(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }

    // 2. request param
    @DeleteMapping("/delete-mapping")
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @RequestParam(name = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }


}