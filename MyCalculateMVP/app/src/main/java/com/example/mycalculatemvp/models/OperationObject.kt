package com.example.calculatermvp.models

class OperationObject {
    val EMPTY_VALUE = "0"
    val ERROR_VALUE = "ERROR"
    val MAX_LENGTH = 10
    val MAX_DECIMAL_DIGITS = 1

    private var mValue: String? = null

    fun getValue(): String? {
        return mValue
    }
    fun setValue(value: String?) {
        mValue = value
    }
    fun appendValue(value: String) {
        if (mValue.isNullOrEmpty()) {
            mValue = value
        } else {
            mValue += value
        }
    }
    fun reset() {
        mValue = EMPTY_VALUE
    }
}