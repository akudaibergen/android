package com.example.mycalculatemvp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculatermvp.models.Calculater
import com.example.calculatermvp.models.OperationObject
import com.example.calculatermvp.presenters.CalculatorPresenter
import com.example.calculatermvp.presenters.ContractInterface

class MainActivity : AppCompatActivity(), ContractInterface.View {
    private var mPresenter: CalculatorPresenter? = null
    private val calculater = Calculater()
    private var firstValue: OperationObject? = null
    private var secondValue: OperationObject? = null

    private var calculationView: TextView? = null
    private var operationView: TextView? = null
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
        mPresenter = CalculatorPresenter(calculater,this, firstValue, secondValue )
        initviews()
    }

    private fun initviews(){
        calculationView = findViewById(R.id.txtv_display_calculation)
        buttonEqal = findViewById(R.id.btn_equals)
        buttonClear = findViewById(R.id.btn_clear)
        button1 = findViewById(R.id.btn_1)
        button2 = findViewById(R.id.btn_2)
        button3 = findViewById(R.id.btn_3)
        button4 = findViewById(R.id.btn_4)
        button5 = findViewById(R.id.btn_5)
        button6 = findViewById(R.id.btn_6)
        button7 = findViewById(R.id.btn_7)
        button8 = findViewById(R.id.btn_8)
        button9 = findViewById(R.id.btn_9)
        button0 = findViewById(R.id.btn_0)
        buttonMulty = findViewById(R.id.btn_multiply)
        buttonDivide = findViewById(R.id.btn_divide)
        buttonPlus = findViewById(R.id.btn_plus)
        buttonMinus = findViewById(R.id.btn_minus)
    }

//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.btn_0 -> {
//                Toast.makeText(this@MainActivity,"Good",Toast.LENGTH_SHORT).show()
//            }
//            R.id.btn_1 -> {
//                mPresenter?.appendValue("1")
//            }
//            R.id.btn_2 -> {
//                mPresenter?.appendValue("2")
//            }
//            R.id.btn_3 -> {
//                mPresenter?.appendValue("3")
//            }
//            R.id.btn_4 -> {
//                mPresenter?.appendValue("4")
//            }
//            R.id.btn_5 -> {
//                mPresenter?.appendValue("5")
//            }
//            R.id.btn_6 -> {
//                mPresenter?.appendValue("6")
//            }
//            R.id.btn_7 -> {
//                mPresenter?.appendValue("7")
//            }
//            R.id.btn_8 -> {
//                mPresenter?.appendValue("8")
//            }
//            R.id.btn_9 -> {
//                mPresenter?.appendValue("9")
//            }
//            R.id.btn_plus -> {
//                mPresenter?.appendOperator("+")
//            }
//            R.id.btn_minus -> {
//                mPresenter?.appendOperator("-")
//            }
//            R.id.btn_multiply -> {
//                mPresenter?.appendOperator("*")
//            }
//            R.id.btn_divide -> {
//                mPresenter?.appendOperator("/")
//            }
//            R.id.btn_clear -> {
//                mPresenter?.clearCalculation()
//            }
//            R.id.btn_equals -> {
//                mPresenter?.performCalculation()
//            }
//        }
//    }

    override fun displayOperand(calculation: String?) {
        calculationView?.text = calculation
    }

    override fun displayOperator(operator: String?) {
        operationView?.text = operator
    }

    fun number0(view: View) {
        mPresenter!!.appendValue("0")
    }
    fun number1(view: View) {
        mPresenter!!.appendValue("1")
    }
    fun number2(view: View) {
        mPresenter!!.appendValue("2")
    }
    fun number3(view: View) {
        mPresenter!!.appendValue("3")
    }
    fun operatorButtonClicked(view: Button) {
        mPresenter!!.appendOperator((view.text.toString()))
    }
    fun clearButtonClicked(view: View) {
        mPresenter!!.clearCalculation()
    }

    fun equalsButtonClicked(view: View) {
        mPresenter!!.performCalculation()
    }

}
