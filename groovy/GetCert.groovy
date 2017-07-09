#!/usr/bin/env groovy
import javax.net.ssl.*
 
if (args.size() != 2) {
    println "usage: getCert host port"
}

def (host, port) = args
def cert
def trustManager = [
    checkClientTrusted: { chain, authType ->  },
    checkServerTrusted: { chain, authType -> cert = chain[0] },
    getAcceptedIssuers: { null }
] as X509TrustManager
 
def context = SSLContext.getInstance("TLS")

context.init(null, [trustManager] as TrustManager[], null)
context.socketFactory.createSocket(host, port as int).with {
    startHandshake()
    close()
}

println "-----BEGIN CERTIFICATE-----"
println cert.encoded.encodeBase64(true)
println "-----END CERTIFICATE-----"
