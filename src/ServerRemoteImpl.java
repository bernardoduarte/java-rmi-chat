import java.io.IOException;
import java.rmi.RemoteException;

public class ServerRemoteImpl implements ServerRemote, MessageListenable {

    private MulticastServer server;

    public ServerRemoteImpl(String address, int socket) throws IOException {
        this.server = new MulticastServer(this, address, socket);
        new Thread(this.server).start();
    }

    @Override
    public void logIn() throws RemoteException {

    }

    @Override
    public void sendMessage(Message msg) throws RemoteException {

    }

    @Override
    public void listenMessage(Message msg) {

    }

}
