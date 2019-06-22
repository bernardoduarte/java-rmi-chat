import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRemoteImpl extends UnicastRemoteObject implements ClientRemote {

    private String name;

    public ClientRemoteImpl(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public void receiveMessage(Message msg) throws RemoteException {
        System.out.println(msg);
    }

    public String getToken() {
        return String.format("Client.%s", name);
    }

    public Message writeMessage(String content) {
        return new Message(this.name, content);
    }
}
