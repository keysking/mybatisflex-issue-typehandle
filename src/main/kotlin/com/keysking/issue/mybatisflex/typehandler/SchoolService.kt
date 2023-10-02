package com.keysking.issue.mybatisflex.typehandler

import com.mybatisflex.spring.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
class SchoolService : ServiceImpl<SchoolRepository, School>() {
    fun add(school: School){
        save(school)
    }
}