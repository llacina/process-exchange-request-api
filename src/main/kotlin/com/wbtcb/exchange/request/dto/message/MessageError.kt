package com.wbtcb.exchange.request.dto.message

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import kotlin.reflect.KProperty

data class MessageError(

    @JsonIgnore
    val errorType: ErrorType,
    @JsonIgnore
    val field: KProperty<*>?,
    @JsonIgnore
    val value: Any?,
    val detail: String? = null
) {

    val fieldName: String?
        @JsonIgnore
        get() = this.field?.let {
            PropertyNamingStrategy.SnakeCaseStrategy().translate(it.name)
        }

    val code
        get() = this.errorType.code

    val title
        get() = this.errorType.title

    val meta
        get() = ObjectMapper().createObjectNode().apply {
            put("source", fieldName)
            put("value", value.toString())
        }
}

enum class ErrorType(val code: String, val title: String) {
    // 1xx validation errors header
    InvalidHeaderFormat("100", "Invalid header, expected format: {channel}.{environment}.{node}"),
    InvalidHeaderEnv("101", "Incompatible header environment"),

    // 2xx validation errors payload
    InvalidValue("201", "Invalid value"),
    ValueOutOfRange("202", "Value out of range"),
    FiatToFiat("203", "Invalid combination FiatToFiat"),
    CryptoToCrypto("204", "Invalid combination CryptoToCrypto"),
    ChannelStockCurrencies("205", "Currency is not allowed for this channel and stock"),

    // 3xx others errors
    ExchangeError("351", "Exchange error");

    companion object {
        fun toErrorType(code: String?): ErrorType? {
            return ErrorType.values().singleOrNull { it.code == code }
        }
    }
}
