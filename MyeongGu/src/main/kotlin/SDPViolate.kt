class InStable {
    fun someInStable() {
        Stable.someStable()
    }
}

class Stable(
    private val uServer: UServer
) {
    companion object {
        fun someStable() {

        }
    }

    fun some() {
        uServer.us()
    }
}

// InStable --> Stable --> UServer <-- Flexible

interface UServer {
    fun us()
}

class Flexible : UServer {
    override fun us() {

    }
}
