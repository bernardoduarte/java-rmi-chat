import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ClientRemote extends Remote {
    public void receiveMessage(Message msg) throws RemoteException;
}
