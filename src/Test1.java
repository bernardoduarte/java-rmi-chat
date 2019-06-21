public class Test1 {

    public static void main(String[] args) throws ConfigurationException {
        Configuration config = new Configuration();
        config.load();
        System.out.println(config.get("multicast.address"));
        System.out.println(config.get("multicast.port"));
        System.out.println(config.get("rmi.port"));
    }

}
