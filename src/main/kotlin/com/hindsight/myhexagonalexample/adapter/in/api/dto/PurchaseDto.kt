package com.hindsight.myhexagonalexample.adapter.`in`.api.dto

data class PurchaseCreateDto(
    val productId: Long,
    val amount: Long,
    val buyerId: Long
)

data class PurchaseAmountUpdateDto(
    val amount: Long
)