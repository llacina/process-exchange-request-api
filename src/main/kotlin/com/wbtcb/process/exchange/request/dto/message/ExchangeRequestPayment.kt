package com.wbtcb.process.exchange.request.dto.message

import com.fasterxml.jackson.databind.JsonNode
import java.io.Serializable

import java.util.UUID

/**
 * Event to start process payment (to_pay)
 */
data class ExchangeRequestPayment constructor(
    val orderRef: UUID,
    val channelCode: String,
    val paymentAddress: String?,
    val metadata: JsonNode?,
    val note: String?
) : Serializable
