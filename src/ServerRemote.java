import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRemote extends Remote {
    public void logIn() throws RemoteException;
    public void sendMessage(Message msg) throws RemoteException;
}
