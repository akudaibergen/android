package com.example.calculatermvp.presenters

import com.example.calculatermvp.models.Operator

interface ContractInterface {
    interface View {
        fun displayOperand(calculation: String?)
        fun displayOperator(operator: String?)
    }

    interface Presenter {
        fun clearCalculation()
        fun appendValue(value: String)
        fun appendOperator(operator: String)
        fun performCalculation()
    }
}