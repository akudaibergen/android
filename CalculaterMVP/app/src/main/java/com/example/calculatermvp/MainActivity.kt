package com.example.calculatermvp

import android.R
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatermvp.presenters.CalculatorPresenter
import com.example.calculatermvp.presenters.ContractInterface


class MainActivity : AppCompatActivity(), ContractInterface.View {

    private var mPresenter: CalculatorPresenter? = null
    private var calculationView: TextView? = null
    private var operationView: TextView? = null

    private var textInput: TextView? = null
    private var buttonClear: Button? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null
    private var button9: Button? = null
    private var button0: Button? = null
    private var buttonMulty: Button? = null
    private var buttonDivide: Button? = null
    private var buttonPlus: Button? = null
    private var buttonMinus: Button? = null
    private var buttonEqal: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    private fun initviews(){
        buttonEqal = findViewById(R.id.equal)
        buttonClear = findViewById(R.id.clear)
        button1 = findViewById(R.id.one)
        button2 = findViewById(R.id.two)
        button3 = findViewById(R.id.three)
        button4 = findViewById(R.id.four)
        button5 = findViewById(R.id.five)
        button6 = findViewById(R.id.six)
        button7 = findViewById(R.id.seven)
        button8 = findViewById(R.id.eight)
        button9 = findViewById(R.id.nine)
        button0 = findViewById(R.id.zero)
        buttonMul = findViewById(R.id.multip)
        buttonDiv = findViewById(R.id.divide)
        buttonPlus = findViewById(R.id.plus)
        buttonMinus = findViewById(R.id.minus)
    }
    override fun displayOperand(calculation: String?) {
        TODO("Not yet implemented")
    }

    override fun displayOperator(operator: String?) {
        TODO("Not yet implemented")
    }
}
