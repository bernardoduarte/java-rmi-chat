import java.io.IOException;

public class Test2 {

    public static void main(String[] args) throws ConfigurationException, IOException {
        Configuration config = new Configuration();
        config.load();
        String address = config.get("multicast.address");
        int port = Integer.parseInt(config.get("multicast.port"));
        MulticastServer server = new MulticastServer(new Listener(), address, port);
        new Thread(server).start();
        MulticastClient client = new MulticastClient(address, port);
        client.send(new Message("Sender", "Olá Mundo!"));
    }

    private static class Listener implements MessageListenable {

        @Override
        public void listenMessage(Message msg) {
            System.out.println(msg);
        }

    }
}
