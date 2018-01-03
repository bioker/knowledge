yeldUnescaped '<!DOCTYPE html>'
html {
    head {
        meta('http-equiv': 'Content-Type', content: 'text/html;charset=utf-8')
        title("${messageProvider.get('home.title')}")
        link(rel: 'stylesheet', href: '/css/styles.css')
    }
    body {
        canvas('id': 'canvas', 'width': '500', 'height': '500'){}
        script(src: 'js/util/GraphUtils.js'){}
        script(src: 'js/model/Node.js'){}
        script(src: 'js/model/Link.js'){}
        script(src: 'js/model/Graph.js'){}
        script(src: 'js/Model.js'){}
        script(src: 'js/View.js'){}
        script(src: 'js/Controller.js'){}
        script(src: 'js/CommandFactory.js'){}
        script(src: 'js/main.js'){}
    }
}