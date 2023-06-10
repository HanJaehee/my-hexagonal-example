package com.hindsight.myhexagonalexample.adapter.out.persistence.entity

import org.springframework.data.relational.core.mapping.Table

@Table("purchase")
data class PurchaseEntity(
    val id: Long? = null,
    val productId: Long,
    val amount: Long,
    val buyerId: Long
)