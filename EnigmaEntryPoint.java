import py4j.GatewayServer;

public class EnigmaEntryPoint {
    private Enigma enigma;

    public EnigmaEntryPoint() {
        enigma = new Enigma();

    }

    public Enigma getEnigma() {
        return enigma;
    }

    public static void main(String[] args) {
        GatewayServer gatewayServer = new GatewayServer(new EnigmaEntryPoint(), 25333);
        gatewayServer.start();
        System.out.println("Server started");
    }
}
