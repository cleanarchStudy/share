// 232p Facade

class Client(
    private val facade: Facade
) {
    fun clientLogin() {
        facade.login()
    }

    fun clientLogout() {
        facade.logout()
    }
}

// client -> facade -> login, logout Service
// client 가 모든 서비스 클래스에 대해 추이 종속성을 가지게 된다.

class Facade(
    private val loginService: LoginService,
    private val logOutService: LogOutService,
) {
    fun login() {
        loginService.execute()
    }

    fun logout() {
        logOutService.execute()
    }
}

class LoginService {

    fun execute() {
        println("로그인")
    }
}

class LogOutService {

    fun execute() {
        println("로그 아웃")
    }
}