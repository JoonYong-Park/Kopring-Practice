package com.joon.kopring.controller.response

import com.joon.kopring.dto.request.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

//        /// 코틀린스럽지 않다.
//        // 1. age == null -> 400 error
//        if (age == null) {
//            return ResponseEntity.status(400).body("age 값 누락")
//        }
//        // 2. age < 20 -> 400 error
//        if (age < 20) {
//            return ResponseEntity.status(400).body("age는 20보다 커야 합니다.")
//        }
//        // 3. age >= 20 -> 200 OK
//        return ResponseEntity.ok("OK")


        /// 코틀린스럽게 작성
        return age?.let {
            // age not null
            if (it < 20) {
                ResponseEntity.status(400).body("age는 20보다 커야 합니다.")
            } else {
                ResponseEntity.ok("OK")
            }
        } ?: ResponseEntity.status(400).body("age 값 누락")
    }

    // 2. post 200
    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest)
    }

    // 3. put 201
    @PutMapping("")
    fun putMapping(@RequestParam userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 1. 기존 데이터가 없어서 새로 생성했다.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.status(500).body(null)
    }

}