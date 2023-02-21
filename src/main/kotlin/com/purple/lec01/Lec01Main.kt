package com.purple.lec01


/** <h1>01. 코틀린에서 변수를 다루는 방법</h1> */

// var: variable (가변)
// val: value (불변)
// 💡tip : 클린한 코드를 위해 모든 변수를 val로 선언하고 필요한 경우에 var로 변경
fun main() {
    var number1 = 10L
    val number2 = 10L

    // 초기값 지정하지 않은 경우, 타입을 명시해야 함
    val number3: Long
//    println(number3) -> Error:초기화 하지 않으면 바로 사용 불가

    number3 = 1_000L
    println(number3)

    // Nullable 변수 : ?를 붙여서 표시
    var number4: Long? = 1_000L
    number4 = null

    // 객체를 인스턴스화할 때는 new 키워드를 사용하지 않는다.
    val person = Person("yubora")
}