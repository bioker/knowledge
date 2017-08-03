import java.io.*
import java.net.*

int port = 8081

ServerSocket serverSocket = new ServerSocket(port)

println 'ServerSocket started: ' + serverSocket

Socket socket = serverSocket.accept()

println 'Connection accepted: ' + socket

try {

    BufferedReader bufferedReader = 
        new BufferedReader(
            new InputStreamReader(
                socket.getInputStream()
            )
        );

    PrintWriter printWriter = 
        new PrintWriter(
            new BufferedWriter(
                new OutputStreamWriter(
                    socket.getOutputStream()
                )
            ), 
            true
        );

    while(true){
        
        String line = bufferedReader.readLine()

        println line
        printWriter.println(line)

        if(line.equals('END')){
            break
        }

    }

} finally {
    serverSocket.close()
    socket.close()
}
