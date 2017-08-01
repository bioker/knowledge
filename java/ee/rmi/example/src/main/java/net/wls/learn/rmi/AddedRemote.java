package net.wls.learn.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddedRemote extends UnicastRemoteObject implements Adder {

    public AddedRemote() throws RemoteException {
        super();
    }

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }
}
