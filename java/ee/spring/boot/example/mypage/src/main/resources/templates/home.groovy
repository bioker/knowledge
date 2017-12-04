yeldUnescaped '<!DOCTYPE html>'
html {
    head {
        meta('http-equiv': 'Content-Type', content: 'text/html;charset=utf-8')
        title("${messageProvider.get('home.title')}")
        script(src: 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js')
    }
    body {
        h1('Hello')
    }
}