import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRemote extends Remote {
    void logIn(String name) throws RemoteException;
    void sendMessage(Message msg) throws RemoteException;
}
