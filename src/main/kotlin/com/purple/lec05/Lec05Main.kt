package com.purple.lec05

/** <h1>05. 코틀린에서 조건문을 다루는 방법</h1>
 */

class Lec05Main {

    private fun validateScoreIsNotNegative(score: Int) {
        if (score < 0) {
            throw IllegalArgumentException("${score}는 0보다 작을 수 없습니다.")
        }
    }

    private fun getPassOrFail(score: Int): String {
//        if (score >= 50) {
//            return "P"
//        } else {
//            return "F"
//        }

        // Kotiln에서 if-else문은 Expression(하나의 값으로 도출되는 문장) 취급 -> 삼항연산자 없음
        // Java에선 Statement(값으로 도출되지 않는 프로그램의 문장)
        // Expression이기 때문에 return을 한번만 표현할 수 있음
        return if (score >= 50) {
            "P"
        } else {
            "F"
        }
    }

    // 중괄호 블럭 {} 없이 = 으로 작성 가능
//    private fun getPassOrFail(score: Int): String =
//        if (score >= 50) {
//            "P"
//        } else {
//            "F"
//        }

    private fun validate(score: Int) {
        // 범위를 의미하는 in.. 연산자
        if (score in 0..100) {
            println()
        }
    }

    private fun getGradeWithSwitch(score: Int): String {
        // Kotlin에서 switch-case는 없어지고 when-else 사용
        // when-else도 Expression
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7 -> "C"
            else -> "D"
        }

        // 다음처럼 조건부에 Expression을 사용하여 표현도 가능
//        return when (score) {
//            in 90..99 -> "A"
//            in 89..80 -> "B"
//            in 79..70 -> "C"
//            else -> "D"
//        }
    }

    // 2강 코드에 when-else 활용
    fun startsWithA(obj: Any): Boolean {
        return when (obj) {
            is String -> obj.startsWith("A")
            else -> false
        }
    }

    private fun judgeNumber(number: Int) {
        return when (number) {
            1, 0, -1 -> println("어디서 많이 본 숫자입니다.")
            else -> println("1, 0, -1이 아닙니다.")
        }
    }

    private fun judgeNumber2(number: Int) {
        return when {
            number == 0 -> println("주어진 숫자는 0입니다.")
            number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
            else -> println("주어진 숫자는 홀수입니다.")
        }
    }
}