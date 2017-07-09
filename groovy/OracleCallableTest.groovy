#!/usr/bin/env groovy
import java.sql.*

String connectionString = "jdbc:oracle:thin:@localhost:1521/test"
String user = ""
String password = ""
String sql = "{CALL test.test(?,?)}"
String request = """Test"""

try{
    Class.forName("oracle.jdbc.OracleDriver")
}catch (ClassNotFoundException e){
    println "classpath not contains oracle jdbc driver"
    return
}

println 'get connection for:'
println 'connection string: ' + connectionString
println 'user: ' + user
println 'password: ***' 
println 'sql: ' + sql


Connection connection = DriverManager.getConnection(connectionString, user, password)
CallableStatement stmt = connection.prepareCall(sql)

stmt.setString(1, request)
stmt.registerOutParameter(2, Types.CLOB)

long timestamp = System.currentTimeMillis()

stmt.execute()

String response = stmt.getString(2)

connection.close()

println 'time for execution (ms): ' + (System.currentTimeMillis() - timestamp)
println 'response:'
println response
