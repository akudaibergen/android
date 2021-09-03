package com.example.calculatermvp.models

import kotlin.text.toDouble as toDouble1

public class Calculater {

    private fun getValue(operand: OperationObject?): Double {
        return operand!!.getValue()!!.toDouble1()
    }

    private fun formatResult(res: Double): String? {
        var res = res
        val digits = Math.pow(10.0, 1.0)
        res = Math.round(res * digits) / digits

        val result = java.lang.Double.toString(res)
        val decimals = result.substring(0, result.indexOf("."))
        var fractionals = result.substring(result.indexOf(".") + 1)

        while (fractionals.length > 0 && fractionals.substring(fractionals.length - 1) == "0") {
            fractionals = fractionals.substring(0, fractionals.length - 1)
        }
        return if (fractionals.length > 0) {
            "$decimals.$fractionals"
        } else {
            decimals
        }
    }

    fun add(firstOperand: OperationObject?, secondOperand: OperationObject?): String? {
        val result = getValue(firstOperand) + getValue(secondOperand)
        return formatResult(result)
    }

    fun minus(firstOperand: OperationObject?, secondOperand: OperationObject?): String? {
        val result = getValue(firstOperand) - getValue(secondOperand)
        return formatResult(result)
    }

    fun multiply(firstOperand: OperationObject?, secondOperand: OperationObject?): String? {
        val result = getValue(firstOperand) * getValue(secondOperand)
        return formatResult(result)
    }

    fun divide(firstOperand: OperationObject?, secondOperand: OperationObject?): String? {
        val result = getValue(firstOperand) / getValue(secondOperand)
        return formatResult(result)
    }


}