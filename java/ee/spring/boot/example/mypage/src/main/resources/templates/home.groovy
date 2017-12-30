yeldUnescaped '<!DOCTYPE html>'
html {
    head {
        meta('http-equiv': 'Content-Type', content: 'text/html;charset=utf-8')
        title("${messageProvider.get('home.title')}")
        script(src: 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'){}
    }
    body {
        canvas('id': 'canvas', 'width': '500', 'height': '500'){}
        script(src: 'js/model/Point.js'){}
        script(src: 'js/model/Link.js'){}
        script(src: 'js/Model.js'){}
        script(src: 'js/View.js'){}
        script(src: 'js/Controller.js'){}
        script(src: 'js/main.js'){}
    }
}