import LoadBalancerPackage.*;
import server.Server;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String Strategy = "RoundRobin";
        LoadBalancingStrategy loadBalancingStrategy = LoadBalancingStrategyManager.getLoadBalancingStrategy(Strategy);
        LoadBalancer lb = new LoadBalancer(loadBalancingStrategy);

        Server s1 = new Server("1", "http://localhost:8081");
        Server s2 = new Server("2", "http://localhost:8082");
        Server s3 = new Server("3", "http://localhost:8083");

        lb.registerServer(s1);
        lb.registerServer(s2);
        lb.registerServer(s3);

        System.out.println("\n--- Round Robin ---");
        for (int i = 1; i <= 6; i++) {
            lb.handleRequest("Request " + i);
        }

        // Switch to random strategy
        lb.setStrategy(new RandomStrategy());

        System.out.println("\n--- Random ---");
        for (int i = 7; i <= 12; i++) {
            lb.handleRequest("Request " + i);
        }
    }
}