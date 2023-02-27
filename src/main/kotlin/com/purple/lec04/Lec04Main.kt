package com.purple.lec04

import com.lannstark.lec04.JavaMoney


/** <h1>04. 코틀린에서 연산자를 다루는 방법</h1> */

fun main() {
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    // 비교연산자를 사용하면 자동으로 compareTo 호출
    if (money1 > money2) {
        println("money1이 money2 보다 큽니다.")
    }

    println("========================")

    // 동등성과 동일성
    // 동등성(Equality): 값이 같은가
    // -> (J) .equals, (K) == (간접적으로 .equals 호출)
    // 동일성(Identity): 주소가 같은가
    // -> (J) ==, (K) ===
    val money3 = JavaMoney(1_000L)
    val money4 = money3
    val money5 = JavaMoney(1_000L)
    println("money3과 money4는 같다 ${money3 === money4}")
    println("money3과 money5는 같은 레퍼런스다 ${money3 === money5}")
    println("money3과 money5는 같은 값이다 ${money3 == money5}")

    println("========================")

    // 연산자 오버로딩
    val money6 = Money(1_000L)
    val money7 = Money(2_000L)
    println("money6과 money7의 합: ${money6 + money7}")
}
