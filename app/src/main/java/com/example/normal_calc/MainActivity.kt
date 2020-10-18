package com.example.normal_calc
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var counter_op: Int = 0
    var num1: Double = 0.0
    var num2: Double = 0.0
    var res_op: Double = 0.0
    var del0coun: Int = 0
    var Answer: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun List_Answer_func(text: String) { /*функция работы с полем для вывода истории запросов на работу калькулятора*/
        counter_op++
        if (counter_op % 10 != 0) { List_Answer.setText(List_Answer.text.toString() + counter_op + ") " + text + "\n") }
        else { List_Answer.setText(counter_op.toString() + ") " + text + "\n") }
    }

    fun operationAll(op: Int, txt: String) { /* Функция для обработки всех кнопок по их коду*/

        if (op == 0) {number1.setText(Answer.toString())} /* Вариант для внесения предыдущего ответа в поле 1 */

        if (number1.text.toString().equals("") || number2.text.toString().equals("")) {
            result_of_op.setText("What are you DOING MAN???")
            List_Answer_func("Error (" + txt + ")")
        }
        else {
            num1 = number1.text.toString().toDouble()
            num2 = number2.text.toString().toDouble()
            res_op = Answer

            if (op == 1){ /* Вариант для сложения */
                res_op = num1 + num2
                result_of_op.text = res_op.toString()
                List_Answer_func(num1.toString() + " + " + num2 + " = " + res_op)
            }
            else if (op == 2) { /* Вариант для вычитания */
                res_op = num1 - num2
                result_of_op.text = res_op.toString()
                List_Answer_func(num1.toString() + " - " + num2 + " = " + res_op)
            }
            else if (op == 3) { /* Вариант для умножения */
                res_op = num1 * num2
                result_of_op.text = res_op.toString()
                List_Answer_func(num1.toString() + " * " + num2 + " = " + res_op)
            }
            else if (op == 4) { /* Вариант для деления */
                if (num2 == 0.0) {
                    del0coun++
                    result_of_op.text = "Гений вне экрана делит на ноль уже " + del0coun.toString() + " раз"
                    List_Answer_func("Error (" + txt + ")")
                }
                else {
                    res_op = num1 / num2
                    result_of_op.text = res_op.toString()
                    List_Answer_func(num1.toString() + " / " + num2 + " = " + res_op)
                }
            }
            Answer = res_op
        }
    }

    // для каждой кнопки запишем просто ее код в функциях для выполнения операции
    fun Answer_button(view: View){ operationAll(0, "") }
    fun Plus_button(view: View){ operationAll(1, "plus") }
    fun Minus_button(view: View){ operationAll(2, "minus") }
    fun Multable_button(view: View){ operationAll(3, "mul") }
    fun Del_button(view: View){ operationAll(4, "del") }

}