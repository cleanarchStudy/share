//로빈 포플스톤은 일급 객체를 구성하는 요소는 기본적인 권리가 있다는, 다음의 정의를 내렸다.

// 1. 모든 요소는 함수의 실제 매개변수가 될 수 있다.
// 2. 모든 요소는 함수의 반환 값이 될 수 있다.
// 3. 모든 요소는 할당 명령문의 대상이 될 수 있다.
// 4. 모든 요소는 동일 비교의 대상이 될 수 있다.


fun main() {
    // 함수를 변수에 할당
    val greet: (String) -> Unit = { name: String -> println("Hello, $name!") }
    greet("World")

    // --------------------------------------------------------------
    // 함수를 다른 함수의 인자로 전달
    fun greetTwice(greeting: (String) -> Unit, name: String) {
        greeting(name)
    }

    greetTwice(greet, "Kotlin")

    // ---------------------------------------------------------------
    // 함수를 결과로 반환
    fun getGreeter(): (String) -> Unit {
        return greet
    }

    val greeter = getGreeter()
    greeter("World")
}


