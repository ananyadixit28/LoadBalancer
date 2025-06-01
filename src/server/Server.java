package server;

public class Server {
    private final String id;
    private final String url;

    public Server(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
    public void handleRequest(String request) {
        System.out.println("server.Server " + id + " handling request: " + request);
    }
}