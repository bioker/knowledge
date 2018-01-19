#!/usr/bin/env groovy

@Grab(group='com.oracle', module='ojdbc6', version='11.2.0')
import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException

if (args.size() != 3) {
    throw new NullPointerException("connectionString, user, password not passed")
}

String connectionString = args[0]
String user = args[1]
String password = args[2]

println 'get connection for:'
println 'connection string: ' + connectionString
println 'user: ' + user
println 'password: ' + password

try{
    Class.forName("oracle.jdbc.OracleDriver")
}catch (ClassNotFoundException e){
    println "classpath not contains oracle jdbc driver"
    return
}

long timestamp = System.currentTimeMillis()

DriverManager.getConnection(connectionString, user, password)

println 'time for getting connection (ms): ' + (System.currentTimeMillis() - timestamp)
