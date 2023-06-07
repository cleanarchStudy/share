// 추상화 (Abstraction)
interface Car {
    fun drive(): String
}

// 저수준 모듈 (Low-level Module)
class Tesla : Car {
    override fun drive(): String {
        return "테슬라 운전"
    }
}

// 저수준 모듈 (Low-level Module)
class Genesis : Car {
    override fun drive(): String {
        return "제네시스 운전"
    }
}

// 고수준 모듈 (High-level Module)
class Driver(private val car: Car) {
    fun driving() {
        car.drive()
    }
}

// Driver -> Car <- Tesla, Genesis

fun main() {
    val tesla = Tesla()

    val driver = Driver(tesla)
    driver.driving()
}
