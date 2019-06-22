import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerRemoteImpl extends UnicastRemoteObject implements ServerRemote, MessageListenable {

    private Registry registry;
    private MulticastServer server;
    private MulticastClient client;
    private ArrayList<String> clientList = new ArrayList<String>();

    public ServerRemoteImpl(Registry registry, String address, int port) throws IOException {
        this.registry = registry;
        this.server = new MulticastServer(this, address, port);
        new Thread(this.server).start();
        this.client = new MulticastClient(address, port);
    }

    @Override
    public void logIn(String name) throws RemoteException {
        this.clientList.add(name);
    }

    @Override
    public void sendMessage(Message msg) throws RemoteException {
        try {
            this.client.send(msg);
        } catch (IOException ioe) {
            throw new RemoteException(ioe.getMessage());
        }
    }

    @Override
    public void listenMessage(Message msg) {
        ArrayList<String> errorClients = new ArrayList<>();
        for (String clientName: clientList) {
            try {
                ClientRemote client = (ClientRemote) this.registry.lookup(clientName);
                client.receiveMessage(msg);
            } catch (RemoteException e) {
                errorClients.add(clientName);
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }

        for (String clientName: errorClients) {
            clientList.remove(clientName);
        }
    }

}
