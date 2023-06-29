// 181p 플러그인 아키텍처

class BusinessComponent {

    interface GUI {
        fun click()
    }

    interface Repository {
        fun save()
        fun delete()
    }
}

// ---

class SomeAGUI : BusinessComponent.GUI {
    override fun click() {}
}

class SomeBGUI : BusinessComponent.GUI {
    override fun click() {}
}

// ---

class MongoDB : BusinessComponent.Repository {
    override fun save() {}

    override fun delete() {}
}

class MySQL : BusinessComponent.Repository {
    override fun save() {}

    override fun delete() {}
}