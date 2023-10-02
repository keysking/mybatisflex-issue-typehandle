package com.keysking.issue.mybatisflex.typehandler

import com.mybatisflex.annotation.Column
import com.mybatisflex.annotation.Table

enum class SchoolType {
    小学, 初中, 高中, 大学,
}

class SchoolTypeArrayTypeHandler : BaseEnumListTypeHandler<SchoolType>(SchoolType::class.java)

@Table("school")
class School(
    var name: String,
    @Column(typeHandler = SchoolTypeArrayTypeHandler::class)
    var types: MutableSet<SchoolType>,
) :BaseEntity(){

}