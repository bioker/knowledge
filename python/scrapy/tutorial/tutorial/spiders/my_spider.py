import scrapy

class MySpider(scrapy.Spider):
    name = "my"

    def start_requests(self):
        urls = [
                'https://habrahabr.ru'
        ]
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        with open('result.html', 'w') as f:
            f.write(response.body)
