public class ClientArgs {

    private String name;

    public ClientArgs(String[] args) {
        this.name = args[0];
    }

    public String getName() {
        return name;
    }

}
