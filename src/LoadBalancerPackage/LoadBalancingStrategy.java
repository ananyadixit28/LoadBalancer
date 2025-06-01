package LoadBalancerPackage;

import server.Server;

import java.util.List;

public interface LoadBalancingStrategy {
    Server selectServer(List<Server> servers);
}