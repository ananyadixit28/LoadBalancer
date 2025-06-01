package LoadBalancerPackage;

import server.Server;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    private final List<Server> servers = new ArrayList<>();
    private LoadBalancingStrategy strategy;

    public LoadBalancer(LoadBalancingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(LoadBalancingStrategy strategy) {
        this.strategy = strategy;
    }

    public void registerServer(Server server) {
        servers.add(server);
        System.out.println("Registered server: " + server.getId());
    }

    public void removeServer(String serverId) {
        servers.removeIf(s -> s.getId().equals(serverId));
        System.out.println("Removed server: " + serverId);
    }

    public void handleRequest(String request) {
        if (servers.isEmpty()) {
            System.out.println("No servers available to handle request.");
            return;
        }
        Server selected = strategy.selectServer(servers);
        selected.handleRequest(request);
    }
}