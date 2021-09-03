package com.example.calculatermvp.models

class Operator {
    enum class Mode(val sumbol: String){
        EMPTY(""),
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/")
    }

    private var operator: String? = null

    fun Operator(operator: String?) {
        this.operator = operator
    }

    fun getOperator(operator: String?): Mode? {
        var mode: Mode? =
            Mode.EMPTY
        when (operator) {
            "+" -> mode = Mode.PLUS
            "-" -> mode = Mode.MINUS
            "*" -> mode = Mode.MULTIPLY
            "/" -> mode = Mode.DIVIDE
        }
        return mode
    }
}
