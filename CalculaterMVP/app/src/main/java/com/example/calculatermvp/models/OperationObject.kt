package com.example.calculatermvp.models

class OperationObject {
    val EMPTY_VALUE = "0"

    private var mValue = EMPTY_VALUE

    fun getValue(): String {
        return mValue
    }
    fun setValue(value: String) {
        mValue = value
    }
    fun appendValue(value: String) {
        if (mValue == EMPTY_VALUE) {
            mValue = value
        } else {
            mValue += value
        }
    }
    fun reset() {
        mValue = EMPTY_VALUE
    }
}