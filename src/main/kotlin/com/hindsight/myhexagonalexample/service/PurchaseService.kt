package com.hindsight.myhexagonalexample.service

import com.hindsight.myhexagonalexample.adapter.`in`.api.dto.PurchaseCreateDto
import com.hindsight.myhexagonalexample.domain.Purchase
import com.hindsight.myhexagonalexample.port.`in`.PurchaseCreatePort
import com.hindsight.myhexagonalexample.port.`in`.PurchaseUpdatePort
import com.hindsight.myhexagonalexample.port.out.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PurchaseService(
    private val createPurchasePort: CreatePurchasePort,
    private val updatePurchasePort: UpdatePurchasePort,
    private val loadPurchasePort: LoadPurchasePort,
    private val loadProductPort: LoadProductPort,
    private val loadBuyerPort: LoadBuyerPort
) : PurchaseCreatePort, PurchaseUpdatePort {

    @Transactional
    override suspend fun createPurchase(dto: PurchaseCreateDto): Purchase {
        loadProductPort.loadProduct(id = dto.productId) ?: throw Exception("존재하지 않는 상품")
        loadBuyerPort.loadBuyer(id = dto.buyerId) ?: throw Exception("존재하지 않는 구매자")

        return createPurchasePort.createPurchase(dto.productId, dto.amount, dto.buyerId)
    }


    @Transactional
    override suspend fun updatePurchaseAmount(id: Long, amount: Long): Purchase {
        val purchase: Purchase = loadPurchasePort.loadPurchase(id = id) ?: throw Exception("구매 정보 없음")

        return updatePurchasePort.updatePurchase(
            purchase = purchase.copy(
                amount = amount
            )
        )
    }
}