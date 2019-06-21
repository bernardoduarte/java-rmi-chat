import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) throws ConfigurationException, IOException {
        Configuration config = new Configuration();
        config.load();
        Registry registry = LocateRegistry.createRegistry(Integer.parseInt(config.get("rmi.port")));
        ServerRemoteImpl server = new ServerRemoteImpl();
        registry.rebind("Server", server);
    }

}
