package com.wbtcb.exchange.request.dto.message

import com.fasterxml.jackson.databind.JsonNode
import com.wbtcb.exchange.request.enum.TradeType

import java.io.Serializable

import java.math.BigDecimal
import java.util.UUID

data class ExchangeRequestMessage constructor(
    val externalId: UUID,
    val channelCode: String,
    val stockCode: String,
    val amount: BigDecimal,
    val tradeType: TradeType,
    val currencyFrom: String,
    val currencyTo: String,
    val addressTo: String?,
    val maxIdleTime: Int?,
    val metadata: JsonNode?,
    val note: String?
) : Serializable
