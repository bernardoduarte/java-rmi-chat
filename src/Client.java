import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws ConfigurationException, IOException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        Configuration config = new Configuration();
        config.load();
        ClientArgs cli = new ClientArgs(args);
        ClientRemoteImpl client = new ClientRemoteImpl(cli.getName());
        Registry registry = LocateRegistry.getRegistry(Integer.parseInt(config.get("rmi.port")));
        registry.rebind(client.getToken(), client);
        ServerRemote server = (ServerRemote) registry.lookup("Server");
        server.logIn(client.getToken());

        while(true) {
            String messageContent = scanner.nextLine();
            Message msg = client.writeMessage(messageContent);
            server.sendMessage(msg);
        }
    }

}
