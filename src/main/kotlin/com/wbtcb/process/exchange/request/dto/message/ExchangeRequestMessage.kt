package com.wbtcb.process.exchange.request.dto.message

import com.fasterxml.jackson.databind.JsonNode
import com.wbtcb.process.exchange.request.enum.TradeType

import java.io.Serializable

import java.math.BigDecimal
import java.util.UUID

data class ExchangeRequestMessage constructor(
    val orderRef: UUID,
    val channelCode: String,
    val stockCode: String?,
    val stockCurrency: String?,
    val amountCoin: BigDecimal,
    val amountFiat: BigDecimal,
    val tradeType: TradeType,
    val currencyCoin: String,
    val currencyFiat: String,
    /**
     * Address for claiming process
     */
    val claimAddress: String?,
    /**
     * Address for paying process
     */
    val paymentAddress: String?,
    val maxIdleTime: Int?,
    val metadata: JsonNode?,
    val note: String?
) : Serializable
