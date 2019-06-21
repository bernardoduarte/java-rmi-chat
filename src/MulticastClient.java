import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class MulticastClient {

    private InetAddress group;
    private int port;

    public MulticastClient(String address, int port) throws UnknownHostException {
        this.group = InetAddress.getByName(address);
        this.port = port;
    }

    public void send(Message msg) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(msg);
        oos.close(); // try oos.flush();
        byte[] buffer = baos.toByteArray();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, this.group, this.port);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);
        socket.close();
    }

}
