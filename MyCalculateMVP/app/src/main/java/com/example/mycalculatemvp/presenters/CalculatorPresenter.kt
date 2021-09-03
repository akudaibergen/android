package com.example.calculatermvp.presenters

import android.content.Context
import android.widget.Toast
import com.example.calculatermvp.models.Calculater
import com.example.calculatermvp.models.OperationObject
import com.example.calculatermvp.models.Operator


class CalculatorPresenter(
    var mCalculator: Calculater,
    var mView: ContractInterface.View,
    var mCurrentOperand: OperationObject?,
    var mPreviousOperand: OperationObject?
) : ContractInterface.Presenter {


    private var mOperator: Operator = Operator()
    private var mode: Operator.Mode? = null
    private var hasLastInputOperator = false
    private var hasLastInputEquals = false
    private var isInErrorState = false


//    fun CalculatorPresenter(
//
//    ) {
//        mCalculator = calculator
//        mView = view
//        mCurrentOperand = currentOperand
//        mPreviousOperand = previousOperand
//        resetCalculator()
//        updateDisplay()
//    }

    override fun clearCalculation() {
        resetCalculator();
        updateDisplay();
    }


    override fun appendValue(value: String) {
        if (hasLastInputOperator) {
            mPreviousOperand?.setValue(mCurrentOperand?.getValue());
            mCurrentOperand?.reset();
        } else if (hasLastInputEquals) {
            resetCalculator();
        }

        if (mCurrentOperand?.getValue()?.length!!.toInt() < 10) {
            mCurrentOperand?.appendValue(value);
            hasLastInputOperator = false;
            hasLastInputEquals = false;
            isInErrorState = false;
            updateDisplay();
        }
    }

    override fun appendOperator(operator: String) {
        if (!isInErrorState) {
            if (mode != Operator.Mode.EMPTY && !hasLastInputOperator) {
                performCalculation();

                if (isInErrorState) {
                    return;
                }
            }

            mode = mOperator.getOperator(operator)
            hasLastInputOperator = true;
            updateDisplay();
        }
    }

    override fun performCalculation() {
        var result: String? = ""

        when (mode) {
            Operator.Mode.PLUS -> result = mCalculator!!.add(mPreviousOperand, mCurrentOperand)
            Operator.Mode.MINUS -> result = mCalculator!!.minus(mPreviousOperand, mCurrentOperand)
            Operator.Mode.MULTIPLY -> result = mCalculator!!.multiply(mPreviousOperand, mCurrentOperand)
            Operator.Mode.DIVIDE ->                 // Check for division by zero
                if (mCurrentOperand!!.getValue() != "0") {
                    result = mCalculator!!.divide(mPreviousOperand, mCurrentOperand)
                }
            else -> result = mCurrentOperand!!.getValue()
        }

        if (result == "" || result!!.length > 10) {
            switchToErrorState()
        } else {
            mCurrentOperand!!.setValue(result)
        }

        mPreviousOperand!!.reset()
        mode = Operator.Mode.EMPTY
        hasLastInputEquals = true
        updateDisplay()
    }

    private fun switchToErrorState() {
        mCurrentOperand!!.setValue("ERROR")
        isInErrorState = true
    }

    private fun resetCalculator() {
        mCurrentOperand!!.reset()
        mPreviousOperand!!.reset()
        hasLastInputEquals = false
        hasLastInputOperator = false
        isInErrorState = false
        mode = Operator.Mode.EMPTY
    }

    private fun updateDisplay() {
        mView!!.displayOperand(mCurrentOperand!!.getValue())
        mView!!.displayOperator(mode.toString())
    }

}