package net.wls.learn.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    private Adder stub;

    public Client(String address) throws RemoteException, NotBoundException, MalformedURLException {
        stub = (Adder) Naming.lookup(address);
    }

    public int add() throws RemoteException {
        return stub.add(2, 2);
    }
}
