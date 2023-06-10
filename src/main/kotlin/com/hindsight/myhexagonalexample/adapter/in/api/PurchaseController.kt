package com.hindsight.myhexagonalexample.adapter.`in`.api

import com.hindsight.myhexagonalexample.adapter.`in`.api.dto.PurchaseAmountUpdateDto
import com.hindsight.myhexagonalexample.adapter.`in`.api.dto.PurchaseCreateDto
import com.hindsight.myhexagonalexample.domain.Purchase
import com.hindsight.myhexagonalexample.port.`in`.PurchaseCreatePort
import com.hindsight.myhexagonalexample.port.`in`.PurchaseUpdatePort
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/purchases")
class PurchaseController(
    private val purchaseCreatePort: PurchaseCreatePort,
    private val purchaseUpdatePort: PurchaseUpdatePort
) {

    @PostMapping
    suspend fun createPurchase(
        @RequestBody dto: PurchaseCreateDto
    ): ResponseEntity<Purchase> {
        return purchaseCreatePort.createPurchase(dto = dto)
            .let { ok().body(it) }
    }

    @PutMapping("/{id}")
    suspend fun updatePurchaseAmount(
        @PathVariable("id") id: Long,
        @RequestBody dto: PurchaseAmountUpdateDto
    ): ResponseEntity<Purchase> {
        return purchaseUpdatePort.updatePurchaseAmount(id = id, amount = dto.amount)
            .let { ok().body(it) }
    }

}