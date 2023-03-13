package lv2

import java.util.Stack
import kotlin.Comparator
import kotlin.math.abs

// https://school.programmers.co.kr/learn/courses/30/lessons/67257
class Pr67257 {
    fun solution(expression: String): Long {
        var answer: Long = Long.MIN_VALUE
        val operatorPriorityLowToHigh = arrayOf("+-*", "+*-", "-+*", "-*+", "*+-", "*-+")
        operatorPriorityLowToHigh.forEach { priority ->
            val result = abs(calculateStack(toPostFix(expression, priority)))
            if(result > answer) answer = result
        }
        return answer
    }

    private fun toPostFix(expression: String, priority: String): Stack<Expr> {
        val comparator = Comparator<Expr.Operator> { o1, o2 ->
            priority.indexOf(o1.opChar).compareTo(priority.indexOf(o2.opChar))
        }
        val strBuilder = StringBuilder()
        val operatorStack = Stack<Expr.Operator>()
        val exprStack = Stack<Expr>()
        expression.forEachIndexed { idx, ch ->
            if(idx == expression.lastIndex) {
                strBuilder.append(ch)
                exprStack.push(Expr.Operand(strBuilder.toString()))
                strBuilder.clear()
                return@forEachIndexed
            }
            if(ch.isDigit()) {
                strBuilder.append(ch)
                return@forEachIndexed
            }
            exprStack.push(Expr.Operand(strBuilder.toString()))
            strBuilder.clear()
            val operator = Expr.Operator.getObject(ch)
            if(operatorStack.isEmpty()) {
                operatorStack.push(operator)
                return@forEachIndexed
            }
            if(comparator.compare(operator, operatorStack.peek()) <= 0) {
                while(operatorStack.isNotEmpty() && comparator.compare(operator, operatorStack.peek()) <= 0) {
                    exprStack.push(operatorStack.pop())
                }
                operatorStack.push(operator)
                return@forEachIndexed
            }
            operatorStack.push(operator)
        }
        while(operatorStack.isNotEmpty()) {
            exprStack.push(operatorStack.pop())
        }
        return exprStack
    }

    private fun calculateStack(exprStack: Stack<Expr>): Long {
        val calStack = Stack<Expr.Operand>()
        exprStack.forEach { expr ->
            when(expr) {
                is Expr.Operand -> {
                    calStack.push(expr)
                }
                is Expr.Operator -> {
                    val right = calStack.pop().value
                    val left = calStack.pop().value
                    calStack.push(
                        Expr.Operand(expr.operate(left, right))
                    )
                }
            }
        }
        return calStack.peek().value
    }

    sealed interface Expr {
        data class Operand(val value: Long) : Expr {
            constructor(numStr: String) : this(numStr.toLong())
            override fun toString(): String = "$value"
        }
        sealed class Operator(val opChar: Char) : Expr {
            override fun toString(): String = "$opChar"
            object Plus: Operator('+') {
                override fun operate(a: Long, b: Long) : Long = a + b
            }
            object Minus: Operator('-') {
                override fun operate(a: Long, b: Long): Long = a - b
            }
            object Multiply: Operator('*') {
                override fun operate(a: Long, b: Long): Long = a * b
            }
            abstract fun operate(a: Long, b: Long) : Long
            companion object {
                fun getObject(ch: Char): Operator {
                    return when(ch) {
                        Plus.opChar -> Plus
                        Minus.opChar -> Minus
                        else -> Multiply
                    }
                }
            }
        }
    }
}

fun main() {
    Pr67257().apply {
        println(solution("100-200*300-500+20"))
        println(solution("50*6-3*2"))
        println(solution("5+2-1*3+2-5*2"))
        println(solution("50+50+50*20*20"))
        // 1248000
        println(solution("200-300-500-600*40+500+500"))
//        println(solution("3+5*2*7-2"))
    }
}