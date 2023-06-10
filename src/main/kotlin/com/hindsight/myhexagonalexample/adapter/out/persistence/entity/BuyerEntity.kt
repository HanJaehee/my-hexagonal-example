package com.hindsight.myhexagonalexample.adapter.out.persistence.entity

import org.springframework.data.relational.core.mapping.Table

@Table("buyer")
data class BuyerEntity(
    val id: Long? = null,
    val name: String
)
