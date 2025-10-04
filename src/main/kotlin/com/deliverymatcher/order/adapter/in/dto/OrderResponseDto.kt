package com.deliverymatcher.order.adapter.`in`.dto

class OrderResponseDto private constructor(
    val id : Long?,
    val memberId: Long,
    val productId: Long,
    val totalAmount: Int,
    val orderStatus: String
) {

    protected constructor() : this(
        id = 0L,
        memberId = 0L,
        productId = 0L,
        totalAmount = 0,
        orderStatus = "CREATED",
    )

    companion object {
        fun of(
            id: Long?,
            memberId: Long,
            productId: Long,
            totalAmount: Int,
            orderStatus: String,
        ): OrderResponseDto {
            return OrderResponseDto(id, memberId, productId, totalAmount, orderStatus)
        }
    }
}