// 일급 객체를 활용한 예시
// 고차 함수(Higher-Order Function)는 다른 함수를 인자로 받거나 함수를 결과로 반환하는 함수를 말함.

fun List<Int>.customFilter(predicate: (Int) -> Boolean): List<Int> {
    val result = mutableListOf<Int>()

    for (number in this) {
        if (predicate(number)) {
            result.add(number)
        }
    }

    return result
}

fun List<Int>.customFilterNot(predicate: (Int) -> Boolean): List<Int> {
    val result = mutableListOf<Int>()

    for (number in this) {
        if (!predicate(number)) {
            result.add(number)
        }
    }

    return result
}


fun List<Int>.customSum(): Int {
    var sum = 0

    for (number in this) {
        sum += number
    }

    return sum
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    val oddNumbers = numbers.customFilter { number -> number % 2 != 0 }
    val sumOfOddNumbers = oddNumbers.customSum()

    println("numbers: $sumOfOddNumbers")
}
