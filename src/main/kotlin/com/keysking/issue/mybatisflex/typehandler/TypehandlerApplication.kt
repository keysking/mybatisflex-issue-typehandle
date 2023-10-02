package com.keysking.issue.mybatisflex.typehandler

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.keysking.issue.mybatisflex.typehandler")
class TypehandlerApplication

fun main(args: Array<String>) {
    runApplication<TypehandlerApplication>(*args)
}
