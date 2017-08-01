package net.wls.learn.rmi;

import java.net.MalformedURLException;
import java.net.URI;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    private String address;
    private Adder skeleton;

    public Server(String address) throws RemoteException {
        this.address = address;
        skeleton = new AddedRemote();
    }

    public void rebind() throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(URI.create(address).getPort());
        Naming.rebind(address, skeleton);
    }

    public void exit() throws RemoteException, NotBoundException, MalformedURLException {
        Naming.unbind(address);
        UnicastRemoteObject.unexportObject(skeleton, true);
    }

}
