package com.joon.kopring.controller.put

import com.joon.kopring.dto.request.UserRequest
import com.joon.kopring.dto.response.Result
import com.joon.kopring.dto.response.UserResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.AbstractBindingResult
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutApiController {

    // PutMapping
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    // RequestMapping
    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "put-request-mapping"
    }

    // object mapper
    @PutMapping("/put-mapping/object")
    fun putMappingObject(
        @Valid @RequestBody userRequest: UserRequest,
        bindingResult: BindingResult
    ): ResponseEntity<String> {

        if (bindingResult.hasErrors()) {
            // 500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }
        return ResponseEntity.ok("OK")

//        // 0. Response
//        return UserResponse().apply {
//            // 1. result
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "성공"
//            }
//        }.apply {
//            // 2. description
//            this.description = "description"
//        }.apply {
//            // 3. user mutable list
//            val userList = mutableListOf<UserRequest>()
//
//            userList.add(userRequest)
//            userList.add(UserRequest().apply {
//                this.name = "준용"
//                this.age = 10
//                this.email = "qwer12@gmail.com"
//                this.address = "서울"
//                this.phoneNumber = "010-1111-2222"
//            })
//            userList.add(UserRequest().apply {
//                this.name = "용준"
//                this.age = 20
//                this.email = "qwer34@gmail.com"
//                this.address = "대전"
//                this.phoneNumber = "010-3333-4444"
//            })
//
//            this.userRequest = userList
//        }

    }


}