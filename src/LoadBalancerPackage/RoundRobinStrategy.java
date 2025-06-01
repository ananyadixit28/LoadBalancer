package LoadBalancerPackage;

import server.Server;

import java.util.List;

public class RoundRobinStrategy implements LoadBalancingStrategy {
    private int index = 0;

    public Server selectServer(List<Server> servers) {
        if (servers.isEmpty()) return null;
        Server server = servers.get(index);
        index = (index + 1) % servers.size();
        return server;
    }
}