import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer implements Runnable {

    private MessageListenable handler;
    private MulticastSocket socket;
    private byte[] buffer = new byte[2048];

    public MulticastServer(MessageListenable handler, String address, int socket) throws IOException {
        this.handler = handler;
        this.socket = new MulticastSocket(socket);
        InetAddress group = InetAddress.getByName(address);
        this.socket.joinGroup(group);
    }

    @Override
    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
                ObjectInputStream ois = new ObjectInputStream(bais);
                Message msg = (Message) ois.readObject();
                handler.listenMessage(msg);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }
    }
}
