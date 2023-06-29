// 210 page

class EasyDBTest() {
    // 서비스가 있으면 아래와 같은 Mock class 를 사용해서 Test 를 진행하면 웹 서버도 필요 없이 가능하다.
}

class MockCrawl() : CrawlingAble {
    override fun crawling() {
        TODO("Not yet implemented")
    }

}

class MockDB() : BusinessComponent.Repository {
    private val map = mutableMapOf<Long, String>()

    override fun save() {
        map[1L] = "Entity"
    }

    override fun delete() {
        map.remove(1L)
    }
}
