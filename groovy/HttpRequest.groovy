#!/usr/bin/env groovy
def baseUrl = new URL('http://test.com')

String body = """Test"""
String response

def connection = baseUrl.openConnection()
connection.setRequestProperty('Content-Type', 'text/plain')

println 'properties: ' + connection.requestProperties

connection.with {
  doOutput = true
  requestMethod = 'POST'
  outputStream.withWriter { writer ->
    writer << body
  }
  response = content.text
}

println 'code: ' + connection.responseCode
println 'message: ' + connection.responseMessage
println 'properties: ' + connection.getHeaderFields()
println 'response: ' + response
