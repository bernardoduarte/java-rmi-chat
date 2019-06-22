import java.io.Serializable;
import java.time.Instant;

public class Message implements Serializable {

    private String sender;
    private String content;
    private String sentAt = Utils.timestamp();

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n[Enviada em: %s, Recebida em: %s]",
                this.sender, this.content, this.sentAt, Utils.timestamp());
    }
}
