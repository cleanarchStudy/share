// 196 page

class SeleniumCrawl()

// Selenium 을 직접적으로 의존하는 서비스
class CrawlService(val seleniumCrawl: SeleniumCrawl) {
    fun crawling() {
        println("do crawling")
    }
}

//------

// 크롤링 한다는 고수준 정책은 정말 중요한 이유에서 변경됨
interface CrawlingAble {
    fun crawling()
}

// 저수준 정책은 더 빈번하게 변경되고, 긴급성, 덜 중요한 이유로 변경되는 경향이 있다.
class JsoupCrawl() : CrawlingAble {
    override fun crawling() {
        // 해당 구현 부분에서 살짝 살짝 수정하는 느낌
        println("using Jsoup")
    }
}

class SomeCrawl() : CrawlingAble {
    override fun crawling() {
        println("using Some")
    }
}


class CrawlServiceV2(private val crawlingAble: CrawlingAble) {
    fun print() {
        println(crawlingAble.crawling())
    }
}