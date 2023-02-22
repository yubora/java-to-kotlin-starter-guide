package com.purple.lec03

import com.lannstark.lec03.Person


/** <h1>03. 코틀린에서 Type을 다루는 방법</h1> */

fun main() {

    // Kotlin은 암시적 타입변경이 불가함
    // Java에서는 int 타입을 long 타입에 어떠한 표시 없이도 할당할 수 있었지만
    // Kotlin에서는 .toType()을 명시적으로 작성해야 함
    val number1 = 3 // int 타입
    val number2: Long = number1.toLong()
    val number3 = number2.toInt()

    // nullable 처리 : safeCall 이용
    val number4: Int? = 3
    val number5: Long = number1?.toLong()

    // 타입캐스팅
    printAgeIfPerson(Person("", 100))
    printAgeIfPersonWithNull(null)
    printAgeIfPersonWithNull(Person("yubora", 100))
    printAgeIfPersonWithNull(100)

    println(
        """
        안녕하세요.
        ${number1}
        Java to Kotlin
    """.trimIndent()
    )

    // 문자열에서 문자를 가져올 때 배열처럼 []를 사용하여 접근할 수 있다.
    // 문자열 길이를 넘어가는 index를 호출하면 IndexOutOfBoundsException 발생
    val str = "ABCD"
    println("str[]: ${str[1]}")
}

// 타입캐스팅
// Any: Java의 Object 타입과 같은 최상위 타입
fun printAgeIfPerson(obj: Any) {
    // (J) instanceof = (K) is
    if (obj is Person) {
        val person = obj as Person

        // 스마트 캐스팅
        // if문에서 Person여부를 체크 했기때문에
        // if문 body에서는 스마트 캐스팅으로 obj를 Person 타입 취급함
        // 'val person = obj as Person' 없이 바로 obj.age 가능
        println(obj.age)
    }

    // obj가 Person이 아니라면 (!is)
    if (obj !is Person) {
        println("Person이 아닙니다.")
    }
}

fun printAgeIfPersonWithNull(obj: Any?) {
    // obj의 타입이 Any? 이기 때문에
    // Person으로 캐스팅 할 때도 as? 를 이용하여 캐스팅 해야 함
    // obj가 Person이 아니라면 = null
    val person = obj as? Person
    println("printAgeIfPerson(obj: Any?): ${person?.age}")
}