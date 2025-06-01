package LoadBalancerPackage;

import server.Server;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements LoadBalancingStrategy {
    private final Random random = new Random();

    public Server selectServer(List<Server> servers) {
        if (servers.isEmpty()) {
            return null;
        }
        int randIndex = random.nextInt(servers.size());
        return servers.get(randIndex);
    }
}