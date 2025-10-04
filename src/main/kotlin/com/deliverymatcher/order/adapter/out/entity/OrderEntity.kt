package com.deliverymatcher.order.adapter.out.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class OrderEntity private constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    val id: Long? = null,

    @Column(name = "member_id")
    val memberId: Long,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "total_amount")
    val totalAmount: Int,

    @Column(name = "status")
    val orderStatus: String,

    @CreatedDate
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null,

    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime? = null
) {

    // NoArgsConstructor(protected)
    protected constructor() : this(
        memberId = 0L,
        productId = 0L,
        totalAmount = 0,
        orderStatus = "PENDING"
    )

    companion object {
        fun of(memberId: Long, productId: Long, totalAmount: Int, orderStatus: String = "PENDING"): OrderEntity {
            return OrderEntity(
                memberId = memberId,
                productId = productId,
                totalAmount = totalAmount,
                orderStatus = orderStatus
            )
        }
    }

}