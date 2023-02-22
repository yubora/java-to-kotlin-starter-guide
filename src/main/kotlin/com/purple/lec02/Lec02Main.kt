package com.purple.lec02

import com.lannstark.lec02.Person


/** <h1>02. 코틀린에서 null을 다루는 방법</h1>
* 1. safeCall (?.)
* 2. Elvis 연산자 (?:): A ?: B -> A가 null이면 B 실행
* 3. null 아님 단언 (!!.)
* 4. 플랫폼타입
 */

fun main() {
    println("startsWithA(\"ABC\"): ${startsWithA("ABC")}")

    println("startsWithA2(null): ${startsWithA2(null)}")
    println("startsWithA2(\"ABC\"): ${startsWithA2("ABC")}")

    println("startsWithA3(null): ${startsWithA3(null)}")
    println("startsWithA3(\"ABC\"): ${startsWithA3("ABC")}")

    println("startsWithA4(\"ABC\"): ${startsWithA4("ABC")}")

    // NPE발생
//    println("startsWithA4(null): ${startsWithA4(null)}")
//    println("startsWithA(null): ${startsWithA(null)}")

    // <JAVA 객체를 Kotlin에서 사용할 때>
    // 플랫폼 타입 (코틀린이 null 관련 정보를 알 수 없는 타입) 다루기
    val person = Person("yubora")
    // Person 객체의 getName에 @Nullable 정보가 있기 때문에 null을 받지 않는 startsWithA5에선 컴파일 오류 발생함
    // @NotNull의 정보를 갖고 있거나, 아무런 정보가 없으면 컴파일 오류 발생하지 않지만
    // 아무런 정보가 없는 상태에서 startsWithA5에서 null을 받게 되면 런타임 오류 발생
    println(startsWithA5(person.name))
}

fun startsWithA(str: String?): Boolean {
//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다.")
//    }
//    return str.startsWith("A")

    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA2(str: String?): Boolean? {
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")

    return str?.startsWith("A") // ?. : str이 null이면 전체 식이 null이 되고, 아니면 뒤 연산의 결과를 반환
}

fun startsWithA3(str: String?): Boolean {
//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")

    return str?.startsWith("A") ?: false
}

// null 아님 단언 (!!.)
// 매개변수가 Nullable 타입이여도 맥락상 절대 null일 경우가 없을 때
// 해당 변수가 널이 아님을 단언해주는 표시
// 이때 null이 들어오게 된다면 NPE 발생
fun startsWithA4(str: String?): Boolean {
    return str!!.startsWith("A")
}

fun startsWithA5(str: String): Boolean {
    return str.startsWith("A")
}
