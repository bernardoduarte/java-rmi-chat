import java.rmi.RemoteException;

public class ClientRemoteImpl implements ClientRemote {

    @Override
    public void receiveMessage(Message msg) throws RemoteException {
        System.out.println(msg);
    }
}
