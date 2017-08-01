package net.wls.learn.rmi;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        String address = "rmi://localhost:49001/adder";
        Server server = new Server(address);
        server.rebind();
        Client client = new Client(address);
        System.out.println(client.add());
        server.exit();
    }
}