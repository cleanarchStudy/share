class X {
    companion object{
        fun utilX() {

        }
    }
}

class A{
    fun someA() {
        X.utilX()
    }
}

class B {
    fun someB() {
        X.utilX()
    }
}
