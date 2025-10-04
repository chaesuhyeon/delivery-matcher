package com.deliverymatcher.order.adapter.`in`.dto

class OrderRequestDto private constructor(
    val memberId: Long,
    val productId: Long,
    val totalAmount: Int,
    val orderStatus: String
) {

    protected constructor() : this(
        memberId = 0L,
        productId = 0L,
        totalAmount = 0,
        orderStatus = "PENDING",
    )

    companion object {
        fun of(
            memberId: Long,
            productId: Long,
            totalAmount: Int,
            orderStatus: String,
        ): OrderRequestDto {
            return OrderRequestDto(memberId, productId, totalAmount, orderStatus)
        }
    }
}