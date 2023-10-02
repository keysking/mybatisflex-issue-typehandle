package com.keysking.issue.mybatisflex.typehandler

import com.mybatisflex.core.query.QueryWrapper
import com.mybatisflex.kotlin.extensions.kproperty.column
import com.mybatisflex.kotlin.extensions.kproperty.toOrd
import com.mybatisflex.kotlin.extensions.sql.toOrd
import com.mybatisflex.kotlin.vec.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class Controller {
    @Autowired
    lateinit var schoolService: SchoolService

    @GetMapping("/add")
    fun add(): School {
        val school = School("test", mutableSetOf(SchoolType.小学, SchoolType.初中))
        schoolService.add(school)
        return school
    }

    @GetMapping("/list")
    fun list(): List<School> {
        return schoolService.list()
    }

    @GetMapping("/order")
    fun order(): List<School> {
        return schoolService.list(QueryWrapper().orderBy(School::id.toOrd(Order.DESC)))
    }

    @GetMapping("/order2")
    fun order2(): List<School> {
        return schoolService.list(QueryWrapper().orderBy(School::id.column().toOrd(Order.DESC)))
    }
}