package com.keysking.issue.mybatisflex.typehandler

import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

abstract class BaseEnumListTypeHandler<T : Enum<T>>(private val clazz: Class<T>) : BaseTypeHandler<MutableSet<T>>() {
    override fun setNonNullParameter(ps: PreparedStatement, i: Int, parameter: MutableSet<T>, jdbcType: JdbcType?) {
        ps.setString(i, parameter.joinToString(separator = ","))
    }

    override fun getNullableResult(rs: ResultSet, columnName: String): MutableSet<T> {
        val str = rs.getString(columnName)
        val names = str.split(",").filter { it.isNotBlank() }
        return names.map { valueOf(it) }.toMutableSet()
    }

    override fun getNullableResult(rs: ResultSet, columnIndex: Int): MutableSet<T> {
        val str = rs.getString(columnIndex)
        val names = str.split(",").filter { it.isNotBlank() }
        return names.map { valueOf(it) }.toMutableSet()
    }

    override fun getNullableResult(cs: CallableStatement, columnIndex: Int): MutableSet<T> {
        val str = cs.getString(columnIndex)
        val names = str.split(",").filter { it.isNotBlank() }
        return names.map { valueOf(it) }.toMutableSet()
    }

    private fun valueOf(value: String): T {
        return java.lang.Enum.valueOf(clazz, value)
    }
}