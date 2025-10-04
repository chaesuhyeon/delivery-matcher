package com.deliverymatcher.order.domain

import java.time.LocalDateTime

class Order private constructor(
    val id: Long?,
    val memberId: Long,
    val productId: Long,
    private var orderStatus: String,
    val totalAmount: Int,
    val createdAt: LocalDateTime,
    private var updatedAt: LocalDateTime? = null
) {

    companion object {
        fun create(memberId: Long, productId: Long, totalAmount: Int): Order {
            val now = LocalDateTime.now()
            return Order(
                id = null,
                memberId = memberId,
                productId = productId,
                totalAmount = totalAmount,
                orderStatus = "CREATED",
                createdAt = now,
                updatedAt = now
            )
        }

        fun of(order: Order): Order {
            return Order(
                id = order.id,
                memberId = order.memberId,
                productId = order.productId,
                orderStatus = order.orderStatus,
                totalAmount = order.totalAmount,
                createdAt = order.createdAt,
                updatedAt = order.updatedAt
            )
        }
    }

    fun markCreated() {
        orderStatus = "CREATED"
        updatedAt = LocalDateTime.now()
    }

    fun markPaid() {
        orderStatus = "PAID"
        updatedAt = LocalDateTime.now()
    }

    fun markCancelled() {
        orderStatus = "CANCELLED"
        updatedAt = LocalDateTime.now()
    }

    fun getStatus(): String = orderStatus
    fun getUpdatedAt(): LocalDateTime? = updatedAt
}
