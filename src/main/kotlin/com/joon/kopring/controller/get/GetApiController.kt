package com.joon.kopring.controller.get

import com.joon.kopring.dto.request.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class GetApiController {

    // GetMapping
    @GetMapping("/hello")
    fun hello(): String {
        return "hello kotlin"
    }

    // RequestMapping
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    // Path Variable
    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, $age")
        return "이름: $name\n나이: $age"
    }

    // Path Variable - 변수명이 겹치는 경우
    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") name1: String, @PathVariable age: Int): String {
        val name = "kotlin"

        println("${name}, ${name1}, $age")
        return "이름: $name1\n나이: $age\n언어: $name"
    }

    // Query Parameter
    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        println("$name, $age")
        return "이름: $name\n나이: $age"
    }

    // Query Parameter - 변수가 많은 경우에 객체로 받기
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    // Query Parameter - Map 형태로 받기
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        return map
    }


}