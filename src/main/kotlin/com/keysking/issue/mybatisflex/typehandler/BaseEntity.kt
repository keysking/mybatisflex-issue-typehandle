package com.keysking.issue.mybatisflex.typehandler

import com.mybatisflex.annotation.Id
import com.mybatisflex.annotation.KeyType

open class BaseEntity {
    @Id(keyType = KeyType.Auto)
    val id: Long? = null
}